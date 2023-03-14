package com.training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorValidation {

    @BeforeClass
    private void beforeAllTests(){
        System.out.println("Thsi is before all tests run begins");
    }

    @BeforeMethod
    private void runsBeforeMethod(){
        System.out.println("This should be executed 2 times");
    }

    @AfterClass
    private void runOnlyAfterClass(){
        System.out.println("Thsi is only once after all method executions");
    }

    private int calculate(int x, int y) {

        int result = x * y;
        return result;
    }

    @Test
    private void testSimple(){

        int result=calculate(2,3);

        Assert.assertEquals(result,6);
    }

    @Test
    private void testSimple1(){

        int result=calculate(20,30);

        Assert.assertEquals(result,700);
    }
}
