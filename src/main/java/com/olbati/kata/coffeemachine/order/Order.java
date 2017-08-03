package com.olbati.kata.coffeemachine.order;

import com.olbati.kata.coffeemachine.products.IProduct;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class Order {

    public final IProduct product;
    final int sugarQuantity;
    public final BigDecimal amountMoney;


    public Order(int sugarQuantity, BigDecimal amountMoney, IProduct product) {
        this.amountMoney = amountMoney;
        this.sugarQuantity = sugarQuantity;
        this.product = product;
    }


    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

}
