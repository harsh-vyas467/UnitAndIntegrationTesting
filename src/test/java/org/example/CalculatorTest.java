package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {


//    test<system under Test>_<Condition pr State Change>_<Expected Result>
    @DisplayName("Test 4/2 = 2")
    @Test
    void testintegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo(){
        Calculator calculator = new Calculator();
        int division = calculator.integerDivision(4,2);
        assertEquals(2, division,"4/2 did, it should produce 2");
    }

    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividedIsDividedByZero_ShouldThrowArithematicException(){


    }

    @DisplayName("Test 5-2=3")
    @Test
    void integerSubtraction(){
        Calculator calculator = new Calculator();
        int a=5,b=2,c=3;
        int subtraction = calculator.integerSubtraction(a,b);
        assertEquals(3,subtraction,()-> a+" - "+b+ " did not produce "+c);

    }



}



