package com.olbati.kata.coffeemachine.order;

import com.olbati.kata.coffeemachine.DrinkType;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class CoffeeOrder extends Order {


    public CoffeeOrder(int sugarQuantity, BigDecimal amountMoney) {
        super(sugarQuantity, amountMoney);
    }

    public CoffeeOrder(int sugarQuantity) {
        super(sugarQuantity);
    }

    @Override
    public DrinkType getDrinkType() {
        return DrinkType.COFFEE;
    }


}
