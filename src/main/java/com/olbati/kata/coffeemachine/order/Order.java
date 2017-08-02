package com.olbati.kata.coffeemachine.order;

import com.olbati.kata.coffeemachine.DrinkType;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public abstract class Order {

    private final int sugarQuantity;

    public Order(int sugarQuantity) {
        this.sugarQuantity = sugarQuantity;
    }

    public abstract DrinkType getDrinkType();

    public int getSugarQuantity() {
        return sugarQuantity;
    }

}
