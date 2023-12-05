package com.jac.mvc.springmvcproject.testexperiment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DummyTest {

    private final Dummy underTest = new Dummy();

    @Test
    void test_addTwoPositive_returnsSum() throws Exception {
        //arrange
        int a = 12;
        int b = 10;

        //real call
        int actual = underTest.customAdd(a, b);

        //verification/assertion
        assertEquals(22, actual);
    }

    @Test
    void test_addTwoZeros_returnsMinusOne() throws Exception {
        //arrange
        int a = 0;
        int b = 0;

        //real call
        int actual = underTest.customAdd(a, b);

        //verification/assertion
        assertEquals(-1, actual);
    }

    @Test
    void test_addOneNegative_throwsException(){
        int a = -2;
        int b = 5;

        assertThrows(
                Exception.class,
                () -> underTest.customAdd(a, b),
                "The number needs to be positive"
        );

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 401, 60001})
    void test_isOdd_returnTrue(int number) throws Exception {
        boolean actual = underTest.isOdd(number);

        assertTrue(actual);
    }
}
