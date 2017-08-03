package com.olbati.kata.coffeemachine.products;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 03/08/2017
 */
public class Tea implements IHotProduct {
    @Override
    public String getCode() {
        return "T";
    }

    @Override
    public BigDecimal getPrice() {
    return new BigDecimal(0.4);
    }
}
