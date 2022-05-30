package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;


public class SortingTest {

    Sorting sorting = new Sorting();

    @Test(expected = IllegalArgumentException.class)
    public void testNullCase() {
        int [] array = null;
        sorting.sort(array);
    }

    @Test
    public void testEmptyCase() {
        int [] array = {};
        sorting.sort(array);

    }

    @Test
    public void testSingleElementArrayCase() {
        int [] expected ={1};
        int [] given ={1};
        sorting.sort(given);
        Assert.assertArrayEquals(given,expected);
    }

    @Test
    public void testSortedArraysCase() {
        int [] expected = {1,2,3,4,5};
        int [] given = {1,2,3,4,5};
        sorting.sort(given);
        Assert.assertArrayEquals(expected,given);
    }

    @Test
    public void testOtherCases() {

        int [] given = {5,3,2,4,1};
        int [] expected = {1,2,3,4,5};
        sorting.sort(given);
        Assert.assertArrayEquals(given,expected);
    }

}