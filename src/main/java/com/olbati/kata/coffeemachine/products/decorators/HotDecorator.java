package com.olbati.kata.coffeemachine.products.decorators;

import com.olbati.kata.coffeemachine.products.IHotProduct;
import com.olbati.kata.coffeemachine.products.IMilkProduct;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 03/08/2017
 */
public class HotDecorator implements IMilkProduct, IHotProduct {

    IHotProduct hotProduct;

    public HotDecorator(IHotProduct hotProduct) {
        this.hotProduct = hotProduct;
    }

    @Override
    public String getCode() {
        return hotProduct.getCode() + "h";
    }

    @Override
    public BigDecimal getPrice() {
        return hotProduct.getPrice();
    }
}
