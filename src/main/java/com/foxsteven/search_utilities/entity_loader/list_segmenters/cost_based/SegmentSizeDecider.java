package com.foxsteven.search_utilities.entity_loader.list_segmenters.cost_based;

public interface SegmentSizeDecider {
    int decideSegmentSize(float maximumSegmentCost, float singleElementCost);
}
