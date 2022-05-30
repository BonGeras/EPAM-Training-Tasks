package com.epam.rd.autotasks;

import java.util.Collection;

public class QuadraticEquation {
    public String solve(double a, double b, double c) {
        if (a == 0) throw new IllegalArgumentException();
        double D = Math.pow(b, 2) - 4 * a * c;
        if (D > 0) {
            double x1 =(-b-Math.pow(D, 0.5)) / (2 * a);
            double x2 =(-b+Math.pow(D, 0.5)) / (2 * a);
            return String.format("%s %s",x1,x2);

        } else if (D == 0) {
            double x1 = -b/(2 * a);
            return ""+x1;
        } else if (D < 0) {
            return "no roots";
        }
        return null;
    }
}