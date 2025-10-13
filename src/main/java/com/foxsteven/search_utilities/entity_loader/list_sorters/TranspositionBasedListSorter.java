package com.foxsteven.search_utilities.entity_loader.list_sorters;

import com.foxsteven.search_utilities.entity_loader.abstractions.PositionBasedListSorter;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranspositionBasedListSorter implements PositionBasedListSorter {
    private final Map<String, Integer> positionMap = new HashMap<>();

    private void prepare(List<String> identifiers) {
        positionMap.clear();

        var index = 0;
        for (final var identifier: identifiers) {
            positionMap.put(identifier, index);
            ++index;
        }
    }

    @Override
    public <T extends StringIdentifiable> void sort(List<String> identifiers, List<T> list) {
        prepare(identifiers);

        if (list.size() != positionMap.size()) {
            throw new RuntimeException("Invalid size");
        }

        for (var i = 0; i < list.size(); ++i) {
            while (true) {
                final var element = list.get(i);
                final var nextPosition = positionMap.get(element.getStringIdentifier());

                if (nextPosition == null) {
                    throw new RuntimeException("Invalid element");
                }

                if (nextPosition == i) {
                    break;
                }

                list.set(i, list.get(nextPosition));
                list.set(nextPosition, element);
            }
        }
    }
}
