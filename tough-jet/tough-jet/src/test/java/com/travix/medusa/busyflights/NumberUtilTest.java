package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.util.NumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberUtilTest {

    private static final double DELTA = 1e-15;

    @Test
    public void testCalculateFinalAmount(){
        double calculatedAmount = NumberUtil.calculateFinalAmount(750D,20D,5D);
        assertEquals(855D,calculatedAmount,DELTA);
    }

    @Test
    public void testCalculateFinalAmountWithOutTax(){
        double calculatedAmount = NumberUtil.calculateFinalAmount(750D,0D,5D);
        assertEquals(712.5D,calculatedAmount,DELTA);
    }

    @Test
    public void testCalculateFinalAmountWithoutDiscount(){
        double calculatedAmount = NumberUtil.calculateFinalAmount(750D,20D,0D);
        assertEquals(900D,calculatedAmount,DELTA);
    }

    @Test
    public void testCalculateFinalAmountWithoutDiscountAndWithoutTax(){
        double calculatedAmount = NumberUtil.calculateFinalAmount(750D,0D,0D);
        assertEquals(750D,calculatedAmount,DELTA);
    }

}
