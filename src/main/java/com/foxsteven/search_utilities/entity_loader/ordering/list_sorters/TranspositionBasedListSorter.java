package com.foxsteven.search_utilities.entity_loader.ordering.list_sorters;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessor;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.PositionBasedListSorter;

import java.util.HashMap;
import java.util.List;

public class TranspositionBasedListSorter implements PositionBasedListSorter {
    @Override
    public <T> void sort(List<T> list, List<String> identifiers, IdentifierAccessor<T> identifierAccessor) {
        final var positionDictionary = new HashMap<String, Integer>(identifiers.size());

        var index = 0;
        for (final var identifier: identifiers) {
            positionDictionary.put(identifier, index);
            ++index;
        }

        for (index = 0; index < list.size(); ++index) {
            while (true) {
                final var element = list.get(index);
                final var actualIndex = positionDictionary.get(identifierAccessor.read(element));

                if (actualIndex == null) {
                    throw new RuntimeException("Invalid arguments");
                }

                if (actualIndex == index) {
                    break;
                }

                list.set(index, list.get(actualIndex));
                list.set(actualIndex, element);
            }
        }
    }
}
