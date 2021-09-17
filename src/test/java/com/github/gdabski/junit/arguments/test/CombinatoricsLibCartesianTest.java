package com.github.gdabski.junit.arguments.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.paukov.combinatorics3.Generator;

import java.util.List;
import java.util.stream.Stream;

class CombinatoricsLibCartesianTest {

    @ParameterizedTest
    @MethodSource("shouldCallTestMethodWithEachElementOfCartesianProduct")
    void shouldCallTestMethodWithEachElementOfCartesianProduct(int i, String s, char ch) {
        System.out.format("%s %s %s%n", i ,s, ch);
    }

    private static Stream<?> shouldCallTestMethodWithEachElementOfCartesianProduct() {
        return Generator.cartesianProduct(
                List.of(1, 2, 3),
                List.of("1", "2", "3"),
                List.of('x', 'y')
        ).stream().map(List::toArray);
    }

}
