package com.foxsteven.search_utilities.entity_loader.list_segmenters;

import java.util.Iterator;
import java.util.List;

public class ConstantSizedListSegments<T> implements Iterable<List<T>> {
    private final List<T> list;

    private final int segmentSize;

    public ConstantSizedListSegments(List<T> list, int segmentSize) {
        this.list = list;
        this.segmentSize = segmentSize;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<List<T>> iterator() {
        return this.new SegmentIterator();
    }

    public class SegmentIterator implements Iterator<List<T>> {
        private int segmentIndex = 0;

        @Override
        public boolean hasNext() {
            return segmentIndex * segmentSize < list.size();
        }

        @Override
        public List<T> next() {
            final var startIndex = segmentIndex * segmentSize;
            final var endIndex = Math.min(startIndex + segmentSize, list.size());

            ++segmentIndex;
            return list.subList(startIndex, endIndex);
        }
    }
}
