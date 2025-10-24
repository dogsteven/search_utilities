package com.foxsteven.search_utilities.entity_loader.ordering.abstractions;

public interface ListSegmenterFactory {
    <T> ListSegmenter create(Class<T> entityClass, int size);
}
