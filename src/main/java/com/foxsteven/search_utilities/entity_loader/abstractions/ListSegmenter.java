package com.foxsteven.search_utilities.entity_loader.abstractions;

import java.util.List;

public interface ListSegmenter {
    <T> Iterable<List<T>> segment(List<T> list);
}
