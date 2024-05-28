package com.megayasa.Backend.Repositories.Impl;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Repositories.QueryRepository;
import com.megayasa.Backend.Annotations.Util.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class QueryRepositoryImpl<T, ID> implements QueryRepository<T, ID> {

    private final Class<T> tClass;
    private final Connection connection;

    protected QueryRepositoryImpl(Class<T> tClass, Connection connection) {
        this.tClass = tClass;
        this.connection = connection;
    }

    @Override
    public Object save(Object entity) {
        try {
            String tableName = ReflectionUtil.getTableName(entity.getClass());
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(entity.getClass());
            String columns = String.join(", ", annotationFields);
            String params = annotationFields.stream().map(s -> new StringBuilder("?")).collect(Collectors.joining(", "));
            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, params);
            PreparedStatement statement = connection.prepareStatement(sql);

            int counter = 1;
            for (Field declaredField : entity.getClass().getDeclaredFields()) {
                declaredField.setAccessible(true);
                Object o = declaredField.get(entity);
                statement.setObject(counter, o);
                counter++;
            }

            statement.executeUpdate();
            statement.close();

            return entity;
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        try {
            if (entities.isEmpty()) throw new RuntimeException("Entities is empty");
            String tableName = ReflectionUtil.getTableName(entities.get(0).getClass());
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(entities.get(0).getClass());
            String columns = String.join(", ", annotationFields);
            String params = annotationFields.stream().map(s -> new StringBuilder("?")).collect(Collectors.joining(", "));
            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, params);
            PreparedStatement statement = connection.prepareStatement(sql);

            for (T entity : entities) {
                int counter = 1;
                for (Field declaredField : entity.getClass().getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    Object o = declaredField.get(entity);
                    statement.setObject(counter, o);
                    counter++;
                }
                statement.addBatch();
            }

            int[] batchResult = statement.executeBatch();

            for (int i : batchResult) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    connection.rollback();
                }
            }

            statement.close();
            return entities;
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try {
            String tableName = ReflectionUtil.getTableName(tClass);
            String annotationId = ReflectionUtil.getAnnotationId(tClass);
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(tClass);
            String columns = String.join(", ", annotationFields);
            String sql = String.format("SELECT %s FROM %s WHERE %s = ?", columns, tableName, annotationId);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);

            ResultSet resultSet = statement.executeQuery();
            T t = null;

            if (resultSet.next()) {
                t = tClass.getDeclaredConstructor().newInstance();
                for (Field declaredField : t.getClass().getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    Column annotation = declaredField.getAnnotation(Column.class);
                    Object value = resultSet.getObject(annotation.name());
                    declaredField.set(t, value);
                }
            }

            statement.close();

            return Optional.ofNullable(t);
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> findOneByFilter(Map<String, Object> filters, String where) {
        try {
            String tableName = ReflectionUtil.getTableName(tClass);
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(tClass);
            String columns = String.join(", ", annotationFields);
            String sql = String.format("SELECT %s FROM %s WHERE ", columns, tableName);

            // Membuat klausa WHERE berdasarkan filters
            List<String> whereClauses = new ArrayList<>();
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                Field fieldT =  tClass.getDeclaredField(filter.getKey());
                Column annotation = fieldT.getAnnotation(Column.class);
                if (annotation != null) {
                    String columnName = annotation.name();
                    whereClauses.add(columnName + " = ?");
                }
            }

            sql += String.join(" "+where+" ", whereClauses);

            PreparedStatement statement = connection.prepareStatement(sql);
            int parameterIndex = 1;
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                Field fieldT =  tClass.getDeclaredField(filter.getKey());
                Column annotation = fieldT.getAnnotation(Column.class);
                if (annotation != null) {
                    Object value = filter.getValue();
                    statement.setObject(parameterIndex, value);
                    parameterIndex ++;
                }
            }

            T t = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                t = tClass.getDeclaredConstructor().newInstance();
                for (Field declaredField : t.getClass().getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    Column annotation = declaredField.getAnnotation(Column.class);
                    Object value = resultSet.getObject(annotation.name());
                    declaredField.set(t, value);
                }
            }

            statement.close();

            return Optional.ofNullable(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> findListByFilter(Map<String, Object> filters, String where) {
        try {
            String tableName = ReflectionUtil.getTableName(tClass);
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(tClass);
            String columns = String.join(", ", annotationFields);
            String sql = String.format("SELECT %s FROM %s", columns, tableName);

            List<String> whereClauses = new ArrayList<>();
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                Field fieldT =  tClass.getDeclaredField(filter.getKey());
                Column annotation = fieldT.getAnnotation(Column.class);
                if (annotation != null) {
                    String columnName = annotation.name();
                    whereClauses.add(columnName + " = ?");
                }
            }

            sql += String.join(" "+where+" ", whereClauses);

            PreparedStatement statement = connection.prepareStatement(sql);
            int parameterIndex = 1;
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                Field fieldT =  tClass.getDeclaredField(filter.getKey());
                Column annotation = fieldT.getAnnotation(Column.class);
                if (annotation != null) {
                    Object value = filter.getValue();
                    statement.setObject(parameterIndex, value);
                    parameterIndex ++;
                }
            }

            ResultSet resultSet = statement.executeQuery();
            List<T> tList = new ArrayList<>();

            while (resultSet.next()) {
                T t = tClass.getDeclaredConstructor().newInstance();
                for (Field declaredField : t.getClass().getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    Column annotation = declaredField.getAnnotation(Column.class);
                    Object value = resultSet.getObject(annotation.name());

                    if (value instanceof LocalDateTime) {
                        declaredField.set(t, value);
                        continue;
                    }

                    declaredField.set(t, value);
                }
                tList.add(t);
            }

            statement.close();
            return tList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            String tableName = ReflectionUtil.getTableName(tClass);
            List<String> annotationFields = ReflectionUtil.getAnnotationFields(tClass);
            String columns = String.join(", ", annotationFields);
            String sql = String.format("SELECT %s FROM %s", columns, tableName);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<T> tList = new ArrayList<>();

            while (resultSet.next()) {
                T t = tClass.getDeclaredConstructor().newInstance();
                for (Field declaredField : t.getClass().getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    Column annotation = declaredField.getAnnotation(Column.class);
                    Object value = resultSet.getObject(annotation.name());

                    if (value instanceof LocalDateTime) {
                        declaredField.set(t, value);
                        continue;
                    }

                    declaredField.set(t, value);
                }
                tList.add(t);
            }

            statement.close();

            return tList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count() {
        try {
            String tableName = ReflectionUtil.getTableName(tClass);
            String query = String.format("Select Count(*) from %s as total", tableName);
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countWithCustomQuery(String query) {
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T update(T entity) {
        try {
            String annotationId = ReflectionUtil.getAnnotationId(entity.getClass());
            String tableName = ReflectionUtil.getTableName(entity.getClass());
            List<String> annotationFields = ReflectionUtil.getAnnotationFieldWithoutId(entity.getClass());

            StringBuilder params = new StringBuilder(annotationFields.size());
            for (String annotationField : annotationFields) {
                params.append(annotationField).append(" = ?, ");
            }

            String substringParams = params.substring(0, params.length() - 2);
            String sql = String.format("UPDATE %s SET %s WHERE %s = ?", tableName, substringParams, annotationId);

            PreparedStatement statement = connection.prepareStatement(sql);
            Object id = null;

            int counter = 1;
            for (Field declaredField : entity.getClass().getDeclaredFields()) {
                declaredField.setAccessible(true);
                if (declaredField.isAnnotationPresent(Id.class)) {
                    id = declaredField.get(entity);
                    continue;
                }
                Object value = declaredField.get(entity);
                statement.setObject(counter, value);
                counter++;
            }

            statement.setObject(counter, id);

            if (id == null) throw new RuntimeException(String.format("%s Id tidak ditemukan", tClass.getSimpleName()));

            statement.executeUpdate();
            statement.close();

            return entity;
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(ID id) {
        try {
            String annotationId = ReflectionUtil.getAnnotationId(tClass);
            String tableName = ReflectionUtil.getTableName(tClass);
            String sql = String.format("DELETE FROM %s WHERE %s = ?", tableName, annotationId);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                throw new RuntimeException(tClass.getSimpleName() + " gagal dihapus, karena terdapat relasi di tabel lain");
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByClass(T entity) {
        try {
            String id = ReflectionUtil.getAnnotationId(entity.getClass());
            String tableName = ReflectionUtil.getTableName(entity.getClass());
            String sql = String.format("DELETE FROM %s WHERE %s = ?", tableName, id);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
