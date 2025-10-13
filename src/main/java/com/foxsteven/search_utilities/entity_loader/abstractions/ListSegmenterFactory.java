package com.foxsteven.search_utilities.entity_loader.abstractions;

public interface ListSegmenterFactory {
    <T> ListSegmenter create(Class<T> entityClass);
}
