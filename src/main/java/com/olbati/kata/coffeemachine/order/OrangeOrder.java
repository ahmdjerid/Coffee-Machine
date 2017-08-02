package com.olbati.kata.coffeemachine.order;

import com.olbati.kata.coffeemachine.DrinkType;
import com.olbati.kata.coffeemachine.order.Order;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 02/08/2017
 */
public class OrangeOrder extends Order {

    public OrangeOrder(int sugarQuantity, BigDecimal amountMoney, Boolean isExtraHot) {

        // orange should already be fresh
        super(sugarQuantity, amountMoney, false);
    }

    @Override
    public DrinkType getDrinkType() {
        return DrinkType.ORANGE;
    }
}
