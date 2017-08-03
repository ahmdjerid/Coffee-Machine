package com.olbati.kata.coffeemachine.products.decorators;

import com.olbati.kata.coffeemachine.products.IHotProduct;
import com.olbati.kata.coffeemachine.products.IMilkProduct;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 03/08/2017
 */
public class MilkDecorator implements IMilkProduct, IHotProduct {

    private IMilkProduct milkProduct;

    public MilkDecorator(IMilkProduct milkProduct) {
        this.milkProduct = milkProduct;
    }

    @Override
    public String getCode() {
        return milkProduct.getCode() + "m";
    }

    @Override
    public BigDecimal getPrice() {
        return milkProduct.getPrice();
    }
}
