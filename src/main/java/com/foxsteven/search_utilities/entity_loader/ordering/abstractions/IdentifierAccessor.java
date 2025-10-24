package com.foxsteven.search_utilities.entity_loader.ordering.abstractions;

public interface IdentifierAccessor<T> {
    String read(T entity);
}
