package com.megayasa.Backend.Repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public interface QueryRepository<T, ID> {
    T save(T entity);
    List<T> saveAll(List<T> entities);
    Optional<T> findById(ID id);
    Optional<T> findOneByFilter(Map<String, Object> filters, String where);
    List<T> findListByFilter(Map<String, Object> filters, String where);
    List<T> findAll();
    int count();
    int countWithCustomQuery(String query);
    T update(T entity);
    void deleteById(ID id);
    void deleteByClass(T entity);
}
