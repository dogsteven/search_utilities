package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.estimators;

import com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.SegmentSizeEstimator;

public class SteppedSegmentSizeEstimatorProxy implements SegmentSizeEstimator {
    private final int segmentStep;

    private final SegmentSizeEstimator estimator;

    public SteppedSegmentSizeEstimatorProxy(int segmentStep, SegmentSizeEstimator estimator) {
        this.segmentStep = segmentStep;
        this.estimator = estimator;
    }

    @Override
    public int estimate(int elementCost, int size) {
        final var estimatedSegmentSize = estimator.estimate(elementCost, size);

        return ((estimatedSegmentSize + segmentStep - 1) / segmentStep) * segmentStep;
    }
}
