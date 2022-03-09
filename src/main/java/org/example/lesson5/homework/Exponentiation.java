package org.example.lesson5.homework;

/*
1. Написать программу по возведению числа в степень с помощью рекурсии.
 */

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(pow(2, 16));
        System.out.println(pow(3, 0));
        System.out.println(pow(0, 3));
        System.out.println(pow(5, -3));
    }

    private static double pow(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent < 0) {
            exponent = exponent * -1;
            return 1 / (base * pow(base, exponent - 1));
        }
        return base * pow(base, exponent - 1);
    }
}
