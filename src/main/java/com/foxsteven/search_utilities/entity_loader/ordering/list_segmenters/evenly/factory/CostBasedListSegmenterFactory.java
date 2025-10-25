package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.ListSegmenter;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.ListSegmenterFactory;
import com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.EvenlyListSegmenter;

import java.util.concurrent.ConcurrentHashMap;

public class CostBasedListSegmenterFactory implements ListSegmenterFactory {
    private final ConcurrentHashMap<Integer, ListSegmenter> listSegmenterDictionary;

    private final SegmentSizeEstimator segmentSizeEstimator;

    private final float mergeThreshold;

    public CostBasedListSegmenterFactory(SegmentSizeEstimator segmentSizeEstimator, float mergeThreshold) {
        this.listSegmenterDictionary = new ConcurrentHashMap<>();
        this.segmentSizeEstimator = segmentSizeEstimator;
        this.mergeThreshold = mergeThreshold;
    }

    @Override
    public <T> ListSegmenter create(Class<T> entityClass, int size) {
        final var loadingCostAnnotation = entityClass.getAnnotation(LoadingCost.class);

        final int elementCost = loadingCostAnnotation != null ? loadingCostAnnotation.value() : 1;

        final var segmentSize = segmentSizeEstimator.estimate(elementCost, size);

        return listSegmenterDictionary.computeIfAbsent(segmentSize, (idealSegmentSize) ->
                new EvenlyListSegmenter(idealSegmentSize, mergeThreshold));
    }
}
