package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DefaultArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public DefaultArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"1", "3", "2"}, new String[] {"1", "2", "3"}},
                {new String[] {"5", "3", "4"}, new String[] {"3", "4", "5"}},
                {new String[] {"4", "2", "5"}, new String[] {"2", "4", "5"}},
                {new String[] {"2", "9", "1"}, new String[] {"1", "2", "9"}}
        });
    }
    @Test
    public void testDefaultArray() {
        app.Sorting(input);
        Assert.assertEquals(input, expected);
    }
}