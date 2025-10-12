package com.foxsteven.search_utilities.entity_loader;

import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionBasedComparator<T extends StringIdentifiable> implements Comparator<T> {
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
    public int compare(T o1, T o2) {
        final var o1Index = positionMap.getOrDefault(o1.getStringIdentifier(), Integer.MAX_VALUE);
        final var o2Index = positionMap.getOrDefault(o2.getStringIdentifier(), Integer.MAX_VALUE);

        return o1Index - o2Index;
    }
}
