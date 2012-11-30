package com.innoq.buildr;

import org.junit.Assert;
import org.junit.Test;

public class FailingTest {

    @Test
    public void weirdMath() {
        Calc c = new Calc(1);
        c.add(1);
        Assert.assertEquals(3, c.getValue());
    }
}
