package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmptyArray {
    protected App app = new App();
    private final String[] input;
    private final String[] expected;


    public EmptyArray(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {}, new String[] {}},
                {new String[] {}, new String[] {}},
                {new String[] {}, new String[] {}},
                {new String[] {}, new String[] {}}
        });
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        app.Sorting(input);
    }
}
