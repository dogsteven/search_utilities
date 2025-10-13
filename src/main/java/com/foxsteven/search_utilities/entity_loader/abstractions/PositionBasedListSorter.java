package com.foxsteven.search_utilities.entity_loader.abstractions;

import java.util.List;

public interface PositionBasedListSorter {
    <T extends StringIdentifiable> void sort(List<String> identifiers, List<T> list);
}
