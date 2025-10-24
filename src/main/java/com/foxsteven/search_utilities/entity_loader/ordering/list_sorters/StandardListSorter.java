package com.foxsteven.search_utilities.entity_loader.ordering.list_sorters;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessor;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.PositionBasedListSorter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardListSorter implements PositionBasedListSorter {
    @Override
    public <T> void sort(List<T> list, List<String> identifiers, IdentifierAccessor<T> identifierAccessor) {
        final var comparator = new StandardComparator<T>(identifiers, identifierAccessor);

        list.sort(comparator);
    }

    public static class StandardComparator<T> implements Comparator<T> {
        private final IdentifierAccessor<T> identifierAccessor;

        private final Map<String, Integer> positionDictionary;

        public StandardComparator(List<String> identifiers, IdentifierAccessor<T> identifierAccessor) {
            this.identifierAccessor = identifierAccessor;
            this.positionDictionary = new HashMap<>(identifiers.size());

            var index = 0;
            for (final var identifier: identifiers) {
                this.positionDictionary.put(identifier, index);
                ++index;
            }
        }

        @Override
        public int compare(T o1, T o2) {
            final var firstIdentifier = identifierAccessor.read(o1);
            final var secondIdentifier = identifierAccessor.read(o2);

            final var firstPosition = positionDictionary.getOrDefault(firstIdentifier, Integer.MAX_VALUE);
            final var secondPosition = positionDictionary.getOrDefault(secondIdentifier, Integer.MAX_VALUE);

            return firstPosition - secondPosition;
        }
    }
}
