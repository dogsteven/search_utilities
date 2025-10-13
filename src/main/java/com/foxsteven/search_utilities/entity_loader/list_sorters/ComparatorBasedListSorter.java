package com.foxsteven.search_utilities.entity_loader.list_sorters;

import com.foxsteven.search_utilities.entity_loader.abstractions.PositionBasedListSorter;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparatorBasedListSorter implements PositionBasedListSorter {
    private final PositionBasedComparator comparator = new PositionBasedComparator();

    @Override
    public <T extends StringIdentifiable> void sort(List<String> identifiers, List<T> list) {
        comparator.prepare(identifiers);

        list.sort(comparator);
    }

    public static class PositionBasedComparator implements Comparator<StringIdentifiable> {
        private final Map<String, Integer> positionMap = new HashMap<>();

        public void prepare(List<String> identifiers) {
            positionMap.clear();

            var index = 0;
            for (final var identifier: identifiers) {
                positionMap.put(identifier, index);
                ++index;
            }
        }

        @Override
        public int compare(StringIdentifiable o1, StringIdentifiable o2) {
            final var o1Index = positionMap.getOrDefault(o1.getStringIdentifier(), Integer.MAX_VALUE);
            final var o2Index = positionMap.getOrDefault(o2.getStringIdentifier(), Integer.MAX_VALUE);

            return o1Index - o2Index;
        }
    }
}
