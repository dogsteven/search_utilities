package com.foxsteven.search_utilities.entity_loader.ordering.list_sorters;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessor;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.PositionBasedListSorter;

import java.util.List;

public class FallbackListSorterDecorator implements PositionBasedListSorter {
    private final PositionBasedListSorter fastSorter;

    private final PositionBasedListSorter safeSorter;

    public FallbackListSorterDecorator(PositionBasedListSorter fastSorter, PositionBasedListSorter safeSorter) {
        this.fastSorter = fastSorter;
        this.safeSorter = safeSorter;
    }

    @Override
    public <T> void sort(List<T> list, List<String> identifiers, IdentifierAccessor<T> identifierAccessor) {
        try {
            if (list.size() == identifiers.size()) {
                fastSorter.sort(list, identifiers, identifierAccessor);
            } else {
                safeSorter.sort(list, identifiers, identifierAccessor);
            }
        } catch (Exception exception) {
            safeSorter.sort(list, identifiers, identifierAccessor);
        }
    }
}
