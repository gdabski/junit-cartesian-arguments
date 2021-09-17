package com.github.gdabski.junit.arguments.test;

import org.junitpioneer.jupiter.CartesianProductTest;
import org.junitpioneer.jupiter.CartesianProductTest.Sets;

import java.util.Set;
import java.util.stream.Stream;

class JunitPioneerCartesianTest {

    @CartesianProductTest
    void shouldCallTestMethodWithEachElementOfCartesianProduct(int i, String s, char ch) {
        System.out.format("%s %s %s%n", i ,s, ch);
    }

    @SuppressWarnings("unused")
    private static Sets shouldCallTestMethodWithEachElementOfCartesianProduct() {
        return new Sets()
                .add(1, 2, 3)
                .addAll(Stream.of("1", "2", "3"))
                .addAll(Set.of('x', 'y'));
    }

}
