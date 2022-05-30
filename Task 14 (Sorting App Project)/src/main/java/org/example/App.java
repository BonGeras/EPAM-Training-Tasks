package org.example;

import java.util.Arrays;

public class App 
{
    public void Sorting (String[] input) {
        if (input.length > 10 || input.length < 1) throw new IllegalArgumentException();
        int[] numsArray = new int[input.length];
        if (input== null) throw new IllegalArgumentException();
        for (int i = 0; i < numsArray.length; i++) {
            if (!checkIfNumber(input[i])) throw new NumberFormatException();
            numsArray[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numsArray);
        for (int i = 0; i < numsArray.length; i++) {
            input[i] = String.valueOf(numsArray[i]);
        }

    }

    public static boolean checkIfNumber (String valueForCheck) {
        if (valueForCheck == null) return false;
        try {
            Integer.parseInt(valueForCheck);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        App app = new App();
        String[] input = {"7","2","4","9","8","1","11","56", "123"};
        app.Sorting(input);
        System.out.println(Arrays.toString(input));
    }
}
