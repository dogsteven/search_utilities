package com.foxsteven.search_utilities.entity_loader.jpa.abstractions;

public interface DatabaseMetadataProvider {
    <T> String provideTableName(Class<T> entityClass);

    <T> String provideIdentifierColumnName(Class<T> entityClass);

    String provideDelimiter();
}
