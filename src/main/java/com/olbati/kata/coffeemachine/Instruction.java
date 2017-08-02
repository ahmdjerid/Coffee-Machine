package com.olbati.kata.coffeemachine;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class Instruction {

    private final DrinkType type;
    private final int sugarQuantity;
    private final boolean withStick;

    public Instruction(DrinkType type, int sugarQuantity, boolean withStick) {
        this.type = type;
        this.sugarQuantity = sugarQuantity;
        this.withStick = withStick;
    }

    public DrinkType getType() {
        return type;
    }

    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public boolean isWithStick() {
        return withStick;
    }

    @Override
    public String toString() {
        return type.getCode() + sugarQuantity + (withStick ? "0" : "");
    }

}
