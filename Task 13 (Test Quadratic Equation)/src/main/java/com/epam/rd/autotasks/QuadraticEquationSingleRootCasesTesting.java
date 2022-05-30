package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;
    private double expected;

    public QuadraticEquationSingleRootCasesTesting(double a, double b, double c, double expected) {
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.expected = expected ;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1,-6,9,3},
                {1,4,4,-2},
                {1,6,9,-3},
                {1,2,1,-1}
        });

    }
    @Test
    public void singleTestCase() {
        String expect = String.valueOf(expected);
        Assert.assertEquals(expect,quadraticEquation.solve(a,b,c));

    }
}



