package org.example.utils;

public class EvenSum {

    public static int calculateEvenSum(int n) {

        if (n < 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            if (i % 8 != 0) {
                sum += i;
            }
        }

        return sum;
    }
}
