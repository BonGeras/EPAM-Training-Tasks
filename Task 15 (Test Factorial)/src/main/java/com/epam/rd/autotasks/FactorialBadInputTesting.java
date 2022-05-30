package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testNullInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null));
    }

    @Test
    void testNegativeInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial.factorial(Integer.MIN_VALUE + ""));
    }

    @Test
    void testFractionalInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial.factorial("5.5"));
    }

    @Test
    void testNonDigitalInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial.factorial("abs"));
    }


}
