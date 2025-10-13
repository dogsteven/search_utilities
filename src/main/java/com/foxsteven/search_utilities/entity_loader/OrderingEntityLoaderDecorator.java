package com.foxsteven.search_utilities.entity_loader;

import com.foxsteven.search_utilities.entity_loader.abstractions.ListSegmenterFactory;
import com.foxsteven.search_utilities.entity_loader.abstractions.PositionBasedListSorter;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiableEntityLoader;

import java.util.ArrayList;
import java.util.List;

public class OrderingEntityLoaderDecorator implements StringIdentifiableEntityLoader {
    private final StringIdentifiableEntityLoader entityLoader;

    private final ListSegmenterFactory listSegmenterFactory;

    private final PositionBasedListSorter listSorter;

    public OrderingEntityLoaderDecorator(StringIdentifiableEntityLoader entityLoader,
                                         ListSegmenterFactory listSegmenterFactory,
                                         PositionBasedListSorter listSorter) {
        this.entityLoader = entityLoader;
        this.listSegmenterFactory = listSegmenterFactory;
        this.listSorter = listSorter;
    }

    @Override
    public <T extends StringIdentifiable> List<T> load(List<String> identifiers, Class<T> entityClass) {
        final var listSegmenter = listSegmenterFactory.create(entityClass);

        final var identifierSegments = listSegmenter.segment(identifiers);

        final var entities = new ArrayList<T>(identifiers.size());

        for (final var identifierSegment: identifierSegments) {
            final var entitySegment = entityLoader.load(identifierSegment, entityClass);

            listSorter.sort(identifiers, entitySegment);

            entities.addAll(entitySegment);
        }

        return entities;
    }
}
