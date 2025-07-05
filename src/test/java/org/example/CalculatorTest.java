package org.example;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup(){
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachTestMethod(){
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @AfterEach method");

    }

//    test<system under Test>_<Condition pr State Change>_<Expected Result>
    @DisplayName("Test 4/2 = 2")
    @Test
    void testintegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo(){
        Calculator calculator = new Calculator();
        int division = calculator.integerDivision(4,2);
        assertEquals(2, division,"4/2 did, it should produce 2");
    }

//    @Disabled("ToDO: Still need to work on it")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividedIsDividedByZero_ShouldThrowArithematicException(){
        System.out.println("Running Division By zero");

        int dividend = 4;
        int divisor=0;
        String expectedExceptionMessage= "/ by zero";

        Exception actualException = assertThrows(ArithmeticException.class, ()->{
            calculator.integerDivision(dividend,divisor);
        },"Divided by zero should have thrown an Arithmetic exception.");

        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected exception message");

    }

    @DisplayName("Test integer subtraction [a,b,expectedResult]")
    @ParameterizedTest
    @MethodSource
    void integerSubtraction(int a,int b,int expectedResult){
        Calculator calculator = new Calculator();
        int subtraction = calculator.integerSubtraction(a,b);
        assertEquals(expectedResult,subtraction,()-> a+" - "+b+ " did not produce "+subtraction);

    }

    private static Stream<Arguments> integerSubtraction(){
        return Stream.of(
                Arguments.of(33,1,32),
                Arguments.of(24,1,23),
                Arguments.of(3,5,-2)
        );

    }



}



