package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NonIntegerElementsArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public NonIntegerElementsArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"3.14", "1", "2"}, new String[] {"1", "2", "3.14"}},
                {new String[] {"1", "9", "2.19"}, new String[] {"1", "2.19", "9"}},
                {new String[] {"6", "3", "6.99"}, new String[] {"3", "6", "6.99"}},
                {new String[] {"4", "2", "7.77"}, new String[] {"2", "4", "7.77"}}
        });
    }
    @Test (expected = NumberFormatException.class)
    public void testNonIntegerElementsArray() {app.Sorting(input);}
}
