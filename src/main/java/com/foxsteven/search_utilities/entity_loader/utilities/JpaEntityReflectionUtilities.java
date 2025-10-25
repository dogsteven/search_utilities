package com.foxsteven.search_utilities.entity_loader.utilities;

import jakarta.persistence.Id;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.UUID;

public class JpaEntityReflectionUtilities {
    public static final Set<Class<?>> stringConvertibleTypeClasses = Set.of(String.class, UUID.class);

    public static Field getTypedIdFieldOfClassHierarchy(Class<?> clazz) {
        return getTypedIdFieldOfClassHierarchy(clazz, stringConvertibleTypeClasses);
    }

    public static Field getTypedIdFieldOfClassHierarchy(Class<?> clazz, Set<Class<?>> typeClasses) {
        Field identifierField = null;

        while (clazz != null) {
            identifierField = getTypedIdFieldOfClass(clazz, typeClasses);

            if (identifierField != null) {
                break;
            }

            clazz = clazz.getSuperclass();
        }

        return identifierField;
    }

    public static Field getTypedIdFieldOfClass(Class<?> clazz, Set<Class<?>> typeClasses) {
        final var declaredFields = clazz.getDeclaredFields();

        for (final var field: declaredFields) {
            if (typeClasses.contains(field.getType())) {
                continue;
            }

            if (field.getAnnotation(Id.class) != null) {
                return field;
            }
        }

        return null;
    }
}
