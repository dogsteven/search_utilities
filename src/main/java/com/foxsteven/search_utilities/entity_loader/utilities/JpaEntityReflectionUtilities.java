package com.foxsteven.search_utilities.entity_loader.utilities;

import jakarta.persistence.Id;

import java.lang.reflect.Field;

public class JpaEntityReflectionUtilities {
    public static Field getTypedIdFieldOfClassHierarchy(Class<?> clazz, Class<?> typeClass) {
        Field identifierField = null;

        while (clazz != null) {
            identifierField = getTypedIdFieldOfClass(clazz, typeClass);

            if (identifierField != null) {
                break;
            }

            clazz = clazz.getSuperclass();
        }

        return identifierField;
    }

    public static Field getTypedIdFieldOfClass(Class<?> clazz, Class<?> typeClass) {
        final var declaredFields = clazz.getDeclaredFields();

        for (final var field: declaredFields) {
            if (field.getType() != typeClass) {
                continue;
            }

            if (field.getAnnotation(Id.class) != null) {
                return field;
            }
        }

        return null;
    }
}
