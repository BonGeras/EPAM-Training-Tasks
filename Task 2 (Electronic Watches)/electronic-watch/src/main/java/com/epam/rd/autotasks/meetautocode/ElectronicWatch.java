package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int minutes = (seconds / 60) % 60;
        int hours = ((seconds / 60) / 60) % 24;
        seconds = seconds % 60;
        String sec = (seconds < 10)? "0" + Integer.toString(seconds) : Integer.toString(seconds);
        String min = (minutes < 10)? "0" + Integer.toString(minutes) : Integer.toString(minutes);
        String hr = Integer.toString(hours);
        System.out.println(hr + ":" + min + ":" + sec);
    }
}
