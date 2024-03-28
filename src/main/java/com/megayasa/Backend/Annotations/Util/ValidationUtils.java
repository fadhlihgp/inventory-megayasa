package com.megayasa.Backend.Annotations.Util;

import com.megayasa.Backend.Annotations.LengthConstraint;
import com.megayasa.Backend.Annotations.MustEmail;
import com.megayasa.Backend.Annotations.MustNumber;
import com.megayasa.Backend.Annotations.NotNullProp;
import com.megayasa.Backend.Exceptions.WarningException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// +++++++++++++++++++++++ Class Untuk validasi Annotation ++++++++++++++++++++++
public class ValidationUtils {
    public static void validate(Object object) throws WarningException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNullProp.class)) {
                validateNotNull(object, field);
            }

            if (field.isAnnotationPresent(MustNumber.class)) {
                validateMustNumber(object, field);
            }

            if (field.isAnnotationPresent(LengthConstraint.class)) {
                validateLengthConstraint(object, field);
            }

            if (field.isAnnotationPresent(MustEmail.class)) {
                validateEmail(object, field);
            }
        }
    }

    // Validasi @NotNullProp
    private static void validateNotNull(Object object, Field field) throws WarningException {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
                NotNullProp annotation = field.getAnnotation(NotNullProp.class);
                String message = annotation.message();
                throw new WarningException(message);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field: " + field.getName());
        }
    }

    // Validasi @MustNumber
    private static void validateMustNumber(Object object, Field field) throws WarningException {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof String) {
                try {
                    new BigDecimal((String) value);
                } catch (NumberFormatException e) {
                    MustNumber annotation = field.getAnnotation(MustNumber.class);
                    String message = annotation.message();
                    throw new WarningException(message);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field: " + field.getName());
        }
    }

    // Validasi @LengthConstraint
    private static void validateLengthConstraint(Object object, Field field) throws WarningException {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof String) {
                LengthConstraint annotation = field.getAnnotation(LengthConstraint.class);
                int minLength = annotation.minLength();
                int maxLength = annotation.maxLength();
                String message = annotation.message();

                String fieldValue = (String) value;
                int fieldLength = fieldValue.length();

                if (fieldLength < minLength || fieldLength > maxLength) {
                    throw new WarningException(message);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field: " + field.getName());
        }
    }

    // Validasi notasi @MustEmail
    private static void validateEmail(Object object, Field field) throws WarningException {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value != null && value instanceof String) {
                String email = (String) value;
                MustEmail annotation = field.getAnnotation(MustEmail.class);
                if (!isValidEmail(email)) {
                    String message = annotation.message();
                    throw new WarningException(message);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field: " + field.getName());
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
