package com.foxsteven.search_utilities.entity_loader.list_segmenters.cost_based;

import com.foxsteven.search_utilities.entity_loader.abstractions.ListSegmenter;
import com.foxsteven.search_utilities.entity_loader.list_segmenters.ConstantSizedListSegments;

import java.util.List;

public class CostBasedListSegmenter implements ListSegmenter {
    private final ClassBasedCostEstimator costEstimator;

    private final SegmentSizeDecider segmentSizeDecider;

    private final float maximumSegmentCost;

    public CostBasedListSegmenter(ClassBasedCostEstimator costEstimator,
                                  SegmentSizeDecider segmentSizeDecider,
                                  float maximumSegmentCost) {
        this.costEstimator = costEstimator;
        this.segmentSizeDecider = segmentSizeDecider;
        this.maximumSegmentCost = maximumSegmentCost;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Iterable<List<T>> segment(List<T> list) {
        if (list.isEmpty()) {
            return List.of();
        }

        final var elementClass = (Class<T>) list.get(0).getClass();
        final float singleElementCost = costEstimator.estimate(elementClass);

        final int segmentSize = segmentSizeDecider.decideSegmentSize(maximumSegmentCost, singleElementCost);

        return new ConstantSizedListSegments<>(list, segmentSize);
    }
}
