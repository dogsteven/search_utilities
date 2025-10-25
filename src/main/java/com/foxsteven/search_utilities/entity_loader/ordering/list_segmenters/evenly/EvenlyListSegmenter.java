package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.ListSegmenter;

import java.util.List;

public class EvenlyListSegmenter implements ListSegmenter {
    private final int idealSegmentSize;

    private final float mergeThreshold;

    public EvenlyListSegmenter(int idealSegmentSize, float mergeThreshold) {
        this.idealSegmentSize = idealSegmentSize;
        this.mergeThreshold = mergeThreshold;
    }

    @Override
    public <T> Iterable<List<T>> segment(List<T> list) {
        return new EvenlyListSegments<>(list, idealSegmentSize, mergeThreshold);
    }
}
