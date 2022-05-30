package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Error on input");
        } else {
            double D = (b * b) - (4 * a * c);
            if (D > 0) {
                double firstRoot = (-b - Math.sqrt(D)) / (2 * a);
                double secondRoot = (-b + Math.sqrt(D)) / (2 * a);
                System.out.print(firstRoot +" "+ secondRoot);
            }
            if (D == 0) {
                double firstRoot = -b / (2 * a);
                System.out.println(firstRoot);
            }
            if (D < 0) {
                System.out.println("no roots");
            }
        }
    }



}