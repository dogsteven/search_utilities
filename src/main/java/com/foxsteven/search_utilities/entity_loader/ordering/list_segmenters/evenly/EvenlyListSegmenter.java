package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.ListSegmenter;

import java.util.List;

public class EvenlyListSegmenter implements ListSegmenter {
    private final int idealSegmentSize;

    public EvenlyListSegmenter(int idealSegmentSize) {
        this.idealSegmentSize = idealSegmentSize;
    }

    @Override
    public <T> Iterable<List<T>> segment(List<T> list) {
        return new EvenlyListSegments<>(list, idealSegmentSize, idealSegmentSize / 4);
    }
}
