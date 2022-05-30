package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NotNumbersArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public NotNumbersArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"q", "3", "2"}, new String[] {"q", "2", "3"}},
                {new String[] {"w", "3", "4"}, new String[] {"w", "4", "5"}},
                {new String[] {"e", "2", "5"}, new String[] {"e", "4", "5"}},
                {new String[] {"r", "9", "1"}, new String[] {"r", "2", "9"}}
        });
    }
    @Test (expected = NumberFormatException.class)
    public void testNotNumberArray() {
        app.Sorting(input);
    }
}
