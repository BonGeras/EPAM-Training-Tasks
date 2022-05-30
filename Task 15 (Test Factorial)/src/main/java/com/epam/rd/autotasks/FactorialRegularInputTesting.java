package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testBigIntegerValue() {
        Assertions.assertEquals("30414093201713378043612608166064768844377641568960512000000000000", factorial.factorial("50"));
    }

    @Test
    void testZeroValue() {
        Assertions.assertEquals("1", factorial.factorial("0"));
    }
}
