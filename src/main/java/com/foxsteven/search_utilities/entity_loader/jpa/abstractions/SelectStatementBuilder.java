package com.foxsteven.search_utilities.entity_loader.jpa.abstractions;

public interface SelectStatementBuilder {
    <T> String buildSelectStatement(int count, Class<T> entityClass);
}
