package com.foxsteven.search_utilities.entity_loader.abstractions;

public interface ClassBasedListSegmenterFactory {
    <T> ListSegmenter create(Class<T> entityClass);
}
