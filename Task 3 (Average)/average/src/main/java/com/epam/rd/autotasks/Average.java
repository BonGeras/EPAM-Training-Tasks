package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");
        int[] intArray = new int[strArray.length-1];
        for (int i = 0; i < strArray.length-1; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        int sum = 0;
        for (int num : intArray) {
            sum+=num;
        }
        int average = sum / intArray.length;
        System.out.println(average);
    }

}