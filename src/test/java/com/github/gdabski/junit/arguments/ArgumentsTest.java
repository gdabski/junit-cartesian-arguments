package com.github.gdabski.junit.arguments;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.gdabski.junit.arguments.Arguments.arguments;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArgumentsTest {

    @Test
    void shouldThrowNullPointerException_when_constructedWithNullVector() {
        // given
        Object[] vector = null;

        // when and then
        assertThrows(NullPointerException.class, () -> arguments(vector));
    }

    @Test
    void shouldThrowNullPointerException_when_constructedWithNullVectorList() {
        // given
        List<Object>[] vectors = null;

        // when and then
        assertThrows(NullPointerException.class, () -> arguments(vectors));
    }

    @Test
    void shouldProduceArgumentsFromSingleVector() {
        // given
        Object[] vector = new Object[]{11, 12, 13};

        // when
        List<Object[]> arguments = newArrayList(Arguments.of(vector));

        // then
        assertEquals(3, arguments.size());
        assertEquals(List.of(11), asList(arguments.get(0)));
        assertEquals(List.of(12), asList(arguments.get(1)));
        assertEquals(List.of(13), asList(arguments.get(2)));
    }

    @Test
    void shouldProduceArgumentsFromSingleVectorAsVarargs() {
        // when
        List<Object[]> arguments = newArrayList(Arguments.of(11, 12, 13));

        // then
        assertEquals(3, arguments.size());
        assertEquals(List.of(11), asList(arguments.get(0)));
        assertEquals(List.of(12), asList(arguments.get(1)));
        assertEquals(List.of(13), asList(arguments.get(2)));
    }

    @Test
    @SuppressWarnings("unchecked")
    void shouldProduceArgumentsFromVectorList() {
        // given
        List<Object>[] vectors = new List[]{
                List.of(11, "11"), // todo nulle
                List.of(12, "12"),
                List.of(13, "13")
        };

        // when
        List<Object[]> arguments = newArrayList(Arguments.of(vectors));

        // then
        assertEquals(3, arguments.size());
        assertEquals(List.of(11, "11"), asList(arguments.get(0)));
        assertEquals(List.of(12, "12"), asList(arguments.get(1)));
        assertEquals(List.of(13, "13"), asList(arguments.get(2)));
    }

    @Test
    void shouldProduceArgumentsFromArgumentsVectorAsVarargs() {
        // when
        List<Object[]> arguments = newArrayList(Arguments.of(
                List.of(11, "11"),
                List.of(12, "12"),
                List.of(13, "13")
        ));

        // then
        assertEquals(3, arguments.size());
        assertEquals(List.of(11, "11"), asList(arguments.get(0)));
        assertEquals(List.of(12, "12"), asList(arguments.get(1)));
        assertEquals(List.of(13, "13"), asList(arguments.get(2)));
    }

//    @Test
//    void shouldProvideArguments(TestInfo testInfo) throws Exception {
//        // given
//        Arguments arguments = arguments(1, 2, 3)
//                .crossJoin(arguments("a", "b", "c"));
//
//        // when
//        List<Object[]> generated = Lists.newArrayList(arguments);
//
//        // then
//        assertEquals(9, generated.size());
//        assertEquals(List.of(1, "a"), asList(generated.get(0)));
//        assertEquals(List.of(1, "b"), asList(generated.get(1)));
//        assertEquals(List.of(1, "c"), asList(generated.get(2)));
//        assertEquals(List.of(2, "a"), asList(generated.get(3)));
//        assertEquals(List.of(2, "b"), asList(generated.get(4)));
//        assertEquals(List.of(2, "c"), asList(generated.get(5)));
//        assertEquals(List.of(3, "a"), asList(generated.get(6)));
//        assertEquals(List.of(3, "b"), asList(generated.get(7)));
//        assertEquals(List.of(3, "c"), asList(generated.get(8)));
//    }

}