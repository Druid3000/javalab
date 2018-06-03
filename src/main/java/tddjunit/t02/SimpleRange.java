package tddjunit.t02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleRange implements Range {
    private long iteratorPosition;
    private long lowerBound;
    private long upperBound;

    SimpleRange(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            this.lowerBound = upperBound;
            this.upperBound = lowerBound;
        } else {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    @Override
    public long getLowerBound() {
        return lowerBound;
    }

    @Override
    public long getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return this.lowerBound> otherRange.getUpperBound();
    }

    @Override
    public boolean isAfter(Range otherRange) {
        return otherRange.getLowerBound()>this.upperBound;
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return this.lowerBound <= otherRange.getUpperBound()
                &&
                this.upperBound >= otherRange.getLowerBound();
    }

    @Override
    public boolean contains(long value) {
        return value >= lowerBound && value <= upperBound;
    }

    @Override
    public List<Long> asList() {
        List<Long> list;
        list = new ArrayList<>();

        for (Long i = lowerBound; i < upperBound; i++) {
            list.add(i);
        }

        return list;
    }

    @Override
    public Iterator<Long> asIterator() {
        iteratorPosition = lowerBound;
        return iterator;
    }

    private Iterator<Long> iterator = new Iterator<Long>() {
        @Override
        public Long next() {
            if (iteratorPosition > upperBound) throw new NoSuchElementException();
            return iteratorPosition++;
        }

        @Override
        public boolean hasNext() {
            return iteratorPosition < upperBound;
        }
    };
}