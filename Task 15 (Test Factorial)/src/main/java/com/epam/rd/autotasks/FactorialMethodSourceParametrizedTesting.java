package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FactorialMethodSourceParametrizedTesting {

    Factorial factorial = new Factorial();

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "2"),
                Arguments.of("5", "120")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFactorial(String in, String expected) {
        Assertions.assertEquals(expected, factorial.factorial(in));
    }
}
