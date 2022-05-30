package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;
    private String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, -7, 12, "3.0 4.0"},
                {1, -5, 6, "2.0 3.0"},
                {1, -3, 2, "1.0 2.0"},
                {1, 2, -3, "-3.0 1.0"}});

    }
    @Test
    public void testTwoRootsCase() {
        double x1 = Double.parseDouble(expected.split(" ")[0]);
        double x2 = Double.parseDouble(expected.split(" ")[1]);
        String result = quadraticEquation.solve(a, b, c);
        Assert.assertTrue(result.equals(x1 + " " + x2) || result.equals(x2 + " " + x1));
    }

}
