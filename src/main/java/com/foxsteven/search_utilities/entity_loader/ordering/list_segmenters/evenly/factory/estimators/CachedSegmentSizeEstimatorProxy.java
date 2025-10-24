package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.estimators;

import com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.SegmentSizeEstimator;

import java.util.concurrent.ConcurrentHashMap;

public class CachedSegmentSizeEstimatorProxy implements SegmentSizeEstimator {
    private final ConcurrentHashMap<CacheKey, Integer> resultCache;

    private final SegmentSizeEstimator estimator;

    public CachedSegmentSizeEstimatorProxy(SegmentSizeEstimator estimator) {
        this.resultCache = new ConcurrentHashMap<>();
        this.estimator = estimator;
    }

    @Override
    public int estimate(int elementCost, int size) {
        return resultCache.computeIfAbsent(new CacheKey(elementCost, size), (key) -> estimator
                .estimate(elementCost, size));
    }

    public record CacheKey(int elementCost, int size) {}
}
