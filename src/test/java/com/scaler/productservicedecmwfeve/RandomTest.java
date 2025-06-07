package com.scaler.productservicedecmwfeve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
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
       assert i == 4;

       assertEquals(i, 4);
    }


}


// a test case is nothing but a method
// test case method is doing: AAA
// Arrange
// Act
// Assert
// A test case fails in any assertion within  test case fails