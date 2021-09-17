package com.github.gdabski.junit.arguments;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class Arguments implements Iterable<Object[]> {

    private final List<List<Object>> arguments;

    private Arguments(List<List<Object>> arguments) {
        this.arguments = arguments;
    }

    public Arguments crossJoin(Arguments arguments) {
        return this;
    }

    public Arguments flatZip(Arguments arguments) {
        return this;
    }

    public static Arguments of(Object... arguments) {
        requireNonNull(arguments, "Arguments array must not be null.");
        return new Arguments(Stream.of(arguments).map(Collections::singletonList).collect(toList()));
    }

    @SafeVarargs
    public static Arguments of(List<Object>... arguments) {
        requireNonNull(arguments, "Arguments array must not be null.");
        return new Arguments(asList(arguments));
    }

    public static Arguments arguments(Object... arguments) {
        return of(arguments);
    }

    @SafeVarargs
    public static Arguments arguments(List<Object>... arguments) {
        return of(arguments);
    }

    @Override
    public Iterator<Object[]> iterator() {
        return new ArgumentsIterator();
    }

    private class ArgumentsIterator implements Iterator<Object[]> {

        private final Iterator<List<Object>> iterator = arguments.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object[] next() {
            return iterator.next().toArray();
        }

    }

}
