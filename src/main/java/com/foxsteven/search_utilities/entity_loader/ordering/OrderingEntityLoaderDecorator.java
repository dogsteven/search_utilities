package com.foxsteven.search_utilities.entity_loader.ordering;

import com.foxsteven.search_utilities.entity_loader.abstractions.EntityLoader;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessorFactory;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.ListSegmenterFactory;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.PositionBasedListSorter;

import java.util.ArrayList;
import java.util.List;

public class OrderingEntityLoaderDecorator implements EntityLoader {
    private final ListSegmenterFactory listSegmenterFactory;

    private final IdentifierAccessorFactory identifierAccessorFactory;

    private final PositionBasedListSorter listSorter;

    private final EntityLoader entityLoader;

    public OrderingEntityLoaderDecorator(ListSegmenterFactory listSegmenterFactory,
                                         IdentifierAccessorFactory identifierAccessorFactory,
                                         PositionBasedListSorter listSorter,
                                         EntityLoader entityLoader) {
        this.listSegmenterFactory = listSegmenterFactory;
        this.identifierAccessorFactory = identifierAccessorFactory;
        this.listSorter = listSorter;
        this.entityLoader = entityLoader;
    }

    @Override
    public <T> List<T> load(List<String> identifiers, Class<T> entityClass) {
        final var listSegmenter = listSegmenterFactory.create(entityClass, identifiers.size());
        final var identifierAccessor = identifierAccessorFactory.create(entityClass);

        final var identifierSegments = listSegmenter.segment(identifiers);

        final var entities = new ArrayList<T>(identifiers.size());

        for (final var identifierSegment: identifierSegments) {
            final var entitySegment = entityLoader.load(identifierSegment, entityClass);

            listSorter.sort(entitySegment, identifiers, identifierAccessor);

            entities.addAll(entitySegment);
        }

        return entities;
    }
}
