package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.estimators;

import com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.SegmentSizeEstimator;

public class SteppedSegmentSizeEstimatorProxy implements SegmentSizeEstimator {
    private final int step;

    private final SegmentSizeEstimator estimator;

    public SteppedSegmentSizeEstimatorProxy(int step, SegmentSizeEstimator estimator) {
        this.step = step;
        this.estimator = estimator;
    }

    @Override
    public int estimate(int elementCost, int size) {
        final var estimatedSegmentSize = estimator.estimate(elementCost, size);

        return ((estimatedSegmentSize + step - 1) / step) * step;
    }
}
