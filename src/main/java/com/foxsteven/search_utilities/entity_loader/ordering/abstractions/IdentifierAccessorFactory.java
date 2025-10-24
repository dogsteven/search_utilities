package com.foxsteven.search_utilities.entity_loader.ordering.abstractions;

public interface IdentifierAccessorFactory {
    <T> IdentifierAccessor<T> create(Class<T> entityClass);
}
