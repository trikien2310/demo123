package org.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenSumTest {

    @Test
    void calculateEvenSum() {

        // 1. Bien nho nhat n = 2
        assertEquals(2, EvenSum.calculateEvenSum(2));

        // 2. Bien lon nhat n = 50
        assertEquals(482, EvenSum.calculateEvenSum(50));

        // 3. n la so chan binh thuong n = 10
        assertEquals(22, EvenSum.calculateEvenSum(10));

        // 4. co so chia het cho 8 bo qua n = 8
        assertEquals(12, EvenSum.calculateEvenSum(8));

        // 5. n < 2
        assertEquals(0, EvenSum.calculateEvenSum(1));
    }


}