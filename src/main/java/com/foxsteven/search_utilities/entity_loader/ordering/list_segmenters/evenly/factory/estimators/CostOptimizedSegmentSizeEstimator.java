package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.estimators;

import com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory.SegmentSizeEstimator;

public class CostOptimizedSegmentSizeEstimator implements SegmentSizeEstimator {
    private final int segmentOverhead;

    public CostOptimizedSegmentSizeEstimator(int segmentOverhead) {
        this.segmentOverhead = segmentOverhead;
    }

    @Override
    public int estimate(int elementCost, int size) {
        final var square = (segmentOverhead * (size - 1) + elementCost - 1) / elementCost;

        if (square == 1) {
            return 1;
        }

        int left = 1;
        int right = square;

        while (left < right - 1) {
            final var middle = (left + right) / 2;

            if (middle * middle < square) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return right;
    }
}
