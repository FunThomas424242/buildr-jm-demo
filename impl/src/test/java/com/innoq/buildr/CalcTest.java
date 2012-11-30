package com.innoq.buildr;

import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test
    public void testAdd() {
        Calc c = new Calc(2);
        c.add(3);
        Assert.assertEquals(5, c.getValue());

        c.add(0);
        Assert.assertEquals(5, c.getValue());
    }


    @Test
    public void testSub() {
        Calc c = new Calc(5);
        c.sub(3);
        Assert.assertEquals(2, c.getValue());

        c.sub(2);
        Assert.assertEquals(0, c.getValue());

        c.sub(2);
        Assert.assertEquals(-2, c.getValue());
    }

}