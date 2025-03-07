package org.example.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodUtilsTest {

    private MethodUtils methodUtils;

    @BeforeEach
    void setUp() {

        methodUtils = new MethodUtils();
    }

    @Test
    void add() {

        assertEquals(5, methodUtils.add(2, 3));
    }

    @Test
    void sub() {

        assertEquals(1, methodUtils.sub(3, 2));
    }
}