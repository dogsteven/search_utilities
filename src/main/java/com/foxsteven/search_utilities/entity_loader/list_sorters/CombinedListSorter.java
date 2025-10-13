package com.foxsteven.search_utilities.entity_loader.list_sorters;

import com.foxsteven.search_utilities.entity_loader.abstractions.PositionBasedListSorter;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;

import java.util.List;

public class CombinedListSorter implements PositionBasedListSorter {
    private final PositionBasedListSorter fastListSorter;

    private final PositionBasedListSorter safeListSorter;

    public CombinedListSorter(PositionBasedListSorter fastListSorter,
                              PositionBasedListSorter safeListSorter) {
        this.fastListSorter = fastListSorter;
        this.safeListSorter = safeListSorter;
    }

    @Override
    public <T extends StringIdentifiable> void sort(List<String> identifiers, List<T> list) {
        try {
            fastListSorter.sort(identifiers, list);
        } catch (RuntimeException ignored) {
            safeListSorter.sort(identifiers, list);
        }
    }
}
