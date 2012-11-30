package com.innoq.buildr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.innoq.buildr.api.ICalc;

public class Calc implements ICalc {

    private final Logger LOG = LoggerFactory.getLogger(Calc.class);

    private int value;

    public Calc(int initValue) {
        value = initValue;
    }

    public void add(int a) {
        LOG.info("Adding {} to {}", a, value);
        value += a;
    }

    public void sub(int a) {
        LOG.info("Subtracting {} from {}", a, value);
        value -= a;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}