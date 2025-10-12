package com.foxsteven.search_utilities.entity_loader.list_segmenters.cost_based;

public interface ClassBasedCostEstimator {
    <T> float estimate(Class<T> elementClass);
}
