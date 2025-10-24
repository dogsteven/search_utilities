package com.foxsteven.search_utilities.entity_loader.ordering.list_segmenters.evenly;

import java.util.Iterator;
import java.util.List;

public class EvenlyListSegments<T> implements Iterable<List<T>> {
    private final List<T> list;

    private final int idealSegmentSize;

    private final int mergeThreshold;

    public EvenlyListSegments(List<T> list, int idealSegmentSize, int mergeThreshold) {
        this.list = list;
        this.idealSegmentSize = idealSegmentSize;
        this.mergeThreshold = mergeThreshold;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<List<T>> iterator() {
        return this.new SegmentIterator();
    }

    public class SegmentIterator implements Iterator<List<T>> {
        private int currentIndex;

        private final boolean shouldMergeLastSegment;

        public SegmentIterator() {
            this.currentIndex = 0;

            final var extraCount = list.size() % idealSegmentSize;

            if (extraCount == 0) {
                this.shouldMergeLastSegment = false;
            } else {
                this.shouldMergeLastSegment = extraCount <= mergeThreshold;
            }
        }


        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public List<T> next() {
            final var startIndex = currentIndex;
            final int endIndex;

            if (shouldMergeLastSegment && startIndex + 2 * idealSegmentSize >= list.size()) {
                endIndex = list.size();
            } else {
                endIndex = startIndex + idealSegmentSize;
            }

            currentIndex = endIndex;

            return list.subList(startIndex, endIndex);
        }
    }
}
