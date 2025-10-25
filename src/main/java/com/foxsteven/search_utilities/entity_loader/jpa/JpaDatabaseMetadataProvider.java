package com.foxsteven.search_utilities.entity_loader.jpa;

import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.DatabaseMetadataProvider;
import com.foxsteven.search_utilities.entity_loader.utilities.JpaEntityReflectionUtilities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public abstract class JpaDatabaseMetadataProvider implements DatabaseMetadataProvider {
    @Override
    public <T> String provideTableName(Class<T> entityClass) {
        if (entityClass.getAnnotation(Entity.class) == null) {
            throw new IllegalArgumentException("Class is not a JPA entity: " + entityClass.getName());
        }

        final var tableAnnotation = entityClass.getAnnotation(Table.class);

        if (tableAnnotation == null || tableAnnotation.name().isBlank()) {
            return entityClass.getSimpleName();
        }

        return tableAnnotation.name();
    }

    @Override
    public <T> String provideIdentifierColumnName(Class<T> entityClass) {
        if (entityClass.getAnnotation(Entity.class) == null) {
            throw new IllegalArgumentException("Class is not a JPA entity: " + entityClass.getName());
        }

        final var identifierField = JpaEntityReflectionUtilities
                .getTypedIdFieldOfClassHierarchy(entityClass);

        if (identifierField == null) {
            throw new IllegalArgumentException("No String-compatible @Id field found in entity class hierarchy");
        }

        final var columnAnnotation = identifierField.getAnnotation(Column.class);

        if (columnAnnotation == null || columnAnnotation.name().isBlank()) {
            return identifierField.getName();
        }

        return columnAnnotation.name();
    }
}
