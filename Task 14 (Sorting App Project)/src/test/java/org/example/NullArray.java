package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NullArray {
        protected App app = new App();
        private final String[] input;
        private final String[] expected;


        public NullArray(String[] input, String[] expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {new String[] {null}, new String[] {null}},
                    {new String[] {null}, new String[] {null}},
                    {new String[] {null}, new String[] {null}},
                    {new String[] {null}, new String[] {null}}
            });
        }
        @Test (expected = IllegalArgumentException.class)
        public void testNullArray() {
            app.Sorting(input);
        }
}
