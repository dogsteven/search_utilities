package com.foxsteven.search_utilities.entity_loader.list_segmenters.constant;

import com.foxsteven.search_utilities.entity_loader.abstractions.ListSegmenter;

import java.util.List;

public class ConstantListSegmenter implements ListSegmenter {
    private final int segmentSize;

    public ConstantListSegmenter(int segmentSize) {
        this.segmentSize = segmentSize <= 0 ? 10 : segmentSize;
    }

    @Override
    public <T> Iterable<List<T>> segment(List<T> list) {
        return new ConstantSizedListSegments<>(list, segmentSize);
    }
}
