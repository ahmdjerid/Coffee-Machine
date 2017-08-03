package com.olbati.kata.coffeemachine.products;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 03/08/2017
 */
public interface IProduct {

    String getCode();

    BigDecimal getPrice();
}
