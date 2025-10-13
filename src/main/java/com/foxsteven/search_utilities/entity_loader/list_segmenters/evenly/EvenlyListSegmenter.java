package com.foxsteven.search_utilities.entity_loader.list_segmenters.evenly;

import com.foxsteven.search_utilities.entity_loader.abstractions.ListSegmenter;

import java.util.List;

public class EvenlyListSegmenter implements ListSegmenter {
    private final int idealSegmentSize;

    public EvenlyListSegmenter(int idealSegmentSize) {
        this.idealSegmentSize = idealSegmentSize <= 0 ? 10 : idealSegmentSize;
    }

    @Override
    public <T> Iterable<List<T>> segment(List<T> list) {
        return new EvenlySizedListSegments<>(list, idealSegmentSize);
    }
}
