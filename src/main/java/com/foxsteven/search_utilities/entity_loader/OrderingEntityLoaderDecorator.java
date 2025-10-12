package com.foxsteven.search_utilities.entity_loader;

import com.foxsteven.search_utilities.entity_loader.abstractions.ListSegmenter;
import com.foxsteven.search_utilities.entity_loader.abstractions.ClassBasedListSegmenterFactory;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiableEntityLoader;

import java.util.ArrayList;
import java.util.List;

public class OrderingEntityLoaderDecorator implements StringIdentifiableEntityLoader {
    private final StringIdentifiableEntityLoader entityLoader;

    private final ClassBasedListSegmenterFactory listSegmenterFactory;

    public OrderingEntityLoaderDecorator(StringIdentifiableEntityLoader entityLoader,
                                         ClassBasedListSegmenterFactory listSegmenterFactory) {
        this.entityLoader = entityLoader;
        this.listSegmenterFactory = listSegmenterFactory;
    }

    @Override
    public <T extends StringIdentifiable> List<T> load(List<String> identifiers, Class<T> entityClass) {
        final var listSegmenter = listSegmenterFactory.create(entityClass);
        final var comparator = new PositionBasedComparator<T>();

        final var identifierSegments = listSegmenter.segment(identifiers);

        final var entities = new ArrayList<T>(identifiers.size());

        for (final var identifierSegment: identifierSegments) {
            final var entitySegment = entityLoader.load(identifierSegment, entityClass);

            comparator.prepare(identifierSegment);
            entitySegment.sort(comparator);

            entities.addAll(entitySegment);
        }

        return entities;
    }
}
