package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SingleElementArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public SingleElementArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"1"}, new String[] {"1"}},
                {new String[] {"3"}, new String[] {"3"}},
                {new String[] {"4"}, new String[] {"4"}},
                {new String[] {"2"}, new String[] {"2"}}
        });
    }
    @Test
    public void testSingleElementArray() {
        app.Sorting(input);
        Assert.assertEquals(input, expected);
    }
}
