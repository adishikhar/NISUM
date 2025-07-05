package com.nisum.calculator.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {

    @Spy
    private PriceFacade priceFacade;

    @Test
    public void testFallbackOnException() {

        doThrow(new ArithmeticException("fail"))
                .when(priceFacade).doCalculation();

        double result = priceFacade.getPrice();


        assertEquals(99.0, result, 0.01);
    }

    @Test
    public void testResetSpyAndCallRealMethod() {
        reset(priceFacade);

        double result = priceFacade.getPrice();


        assertEquals(120.0, result, 0.01);
    }
}
