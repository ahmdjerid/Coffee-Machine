package com.olbati.kata.coffeemachine.order;

import com.olbati.kata.coffeemachine.DrinkType;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public abstract class Order {

    private final int sugarQuantity;
    private BigDecimal amountMoney = BigDecimal.ZERO;

    public Order(int sugarQuantity) {
        this.sugarQuantity = sugarQuantity;
    }

    public Order(int sugarQuantity, BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
        this.sugarQuantity = sugarQuantity;
    }

    public abstract DrinkType getDrinkType();

    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }
}
