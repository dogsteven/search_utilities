package com.foxsteven.search_utilities.entity_loader.ordering.identifier_accessors;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessor;
import com.foxsteven.search_utilities.entity_loader.utilities.JpaEntityReflectionUtilities;
import jakarta.persistence.Entity;

import java.lang.reflect.Field;

public class JpaIdentifierAccessor<T> implements IdentifierAccessor<T> {
    private volatile Field identifierField;

    public JpaIdentifierAccessor() {
        this.identifierField = null;
    }

    @Override
    public String read(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Cannot get identifier of a null object");
        }

        if (identifierField == null) {
            synchronized (this) {
                if (identifierField == null) {
                    identifierField = extractIdentifierField(entity.getClass());
                }
            }
        }

        try {
            return identifierField.get(entity).toString();
        } catch (IllegalAccessException exception) {
            throw new RuntimeException("Failed to access identifier field", exception);
        }
    }

    private Field extractIdentifierField(Class<?> entityClass) {
        if (entityClass.getAnnotation(Entity.class) == null) {
            throw new IllegalArgumentException("Class is not a JPA entity: " + entityClass.getName());
        }

        final var identifierField = JpaEntityReflectionUtilities
                .getTypedIdFieldOfClassHierarchy(entityClass);

        if (identifierField == null) {
            throw new IllegalArgumentException("No String-compatible @Id field found in entity class hierarchy");
        }

        identifierField.setAccessible(true);

        return identifierField;
    }
}
