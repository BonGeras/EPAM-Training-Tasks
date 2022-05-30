package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OverloadedArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public OverloadedArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"1", "4", "2", "3", "3", "3", "3", "3", "3", "3", "3"}, new String[] {"1", "2", "3", "3", "3", "3", "3", "3", "3", "3", "4"}},
                {new String[] {"1", "4", "2", "3", "3", "3", "3", "3", "3", "5", "3"}, new String[] {"1", "2", "3", "3", "3", "3", "3", "3", "3", "4", "5"}},
                {new String[] {"1", "4", "2", "3", "3", "3", "3", "3", "8", "5", "3"}, new String[] {"1", "2", "3", "3", "3", "3", "3", "3", "4", "5", "8"}},
                {new String[] {"1", "4", "2", "3", "3", "3", "3", "9", "8", "5", "3"}, new String[] {"1", "2", "3", "3", "3", "3", "3", "4", "5", "8", "9"}}
        });
    }
    @Test (expected = IllegalArgumentException.class)
    public void testOverloadedArray() {
        app.Sorting(input);
    }
}
