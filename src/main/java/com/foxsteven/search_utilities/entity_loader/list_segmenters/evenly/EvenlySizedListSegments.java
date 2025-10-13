package com.foxsteven.search_utilities.entity_loader.list_segmenters.evenly;

import java.util.Iterator;
import java.util.List;

public class EvenlySizedListSegments<T> implements Iterable<List<T>> {
    private final List<T> list;

    private final int idealSegmentSize;

    public EvenlySizedListSegments(List<T> list, int idealSegmentSize) {
        this.list = list;
        this.idealSegmentSize = idealSegmentSize;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<List<T>> iterator() {
        return this.new SegmentIterator();
    }

    public class SegmentIterator implements Iterator<List<T>> {
        private int remainingExtra = list.size() % idealSegmentSize;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public List<T> next() {
            final var startIndex = currentIndex;
            final var currentSize = idealSegmentSize + (remainingExtra > 0 ? 1 : 0);
            final var endIndex = Math.min(startIndex + currentSize, list.size());

            currentIndex = endIndex;
            if (remainingExtra > 0) {
                --remainingExtra;
            }

            return list.subList(startIndex, endIndex);
        }
    }
}
