package com.scaler.productservicedecmwfeve;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {
    @Test
    void testOnePlusOneIsTwo() {
        int i = 1 + 1; //act
        assert i == 2;
        assertEquals(2, i);
    }

    @Test
    void testTwoTwoZaFour() {
       int i  = 2 * 2;
       assertEquals(4, i);
    }


}


// a test case is nothing but a method
// test case method is doing: AAA
// Arrange
// Act
// Assert
// A test case fails in any assertion within a test case fails