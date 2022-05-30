package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Factorial {
    public String factorial(String n) {
        if (n == null){
            throw new IllegalArgumentException();
        }
        BigInteger result = BigInteger.valueOf(1);
        int number;
        try{
            number = Integer.parseInt(n);
        }catch (NumberFormatException e){
            throw  new IllegalArgumentException();
        }
        if (number < 0){
            throw new IllegalArgumentException();
        }
        if (number == 0 || number == 1){
            return result + "";
        }
        for (int i = 2; i<= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result + "";
    }
}
