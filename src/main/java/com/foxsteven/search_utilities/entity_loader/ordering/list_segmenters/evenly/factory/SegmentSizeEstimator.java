package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly.factory;

public interface SegmentSizeEstimator {
    int estimate(int elementCost, int size);
}
