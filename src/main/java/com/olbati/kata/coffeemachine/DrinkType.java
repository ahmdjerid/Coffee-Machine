package com.olbati.kata.coffeemachine;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public enum DrinkType {

    COFFEE('C', new BigDecimal(0.6)),
    TEA('T', new BigDecimal(0.4)),
    CHOCOLATE('H', new BigDecimal(0.5)),
    ORANGE('O', new BigDecimal(0.6));

    private char code;
    private BigDecimal price;

    DrinkType(char code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }

    public char getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
