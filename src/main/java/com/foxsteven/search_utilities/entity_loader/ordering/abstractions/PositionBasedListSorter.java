package com.foxsteven.search_utilities.entity_loader.ordering.abstractions;

import java.util.List;

public interface PositionBasedListSorter {
    <T> void sort(List<T> list, List<String> identifiers, IdentifierAccessor<T> identifierAccessor);
}
