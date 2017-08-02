package com.olbati.kata.coffeemachine;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class Instruction {

    private final DrinkType type;
    private final int sugarQuantity;
    private final boolean withStick;
    private final boolean isExtraHot;


    public Instruction(DrinkType type, int sugarQuantity, boolean withStick, boolean isExtraHot) {
        this.type = type;
        this.sugarQuantity = sugarQuantity;
        this.withStick = withStick;
        this.isExtraHot = isExtraHot;
    }

    public DrinkType getType() {
        return type;
    }

    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public boolean isExtraHot()
    {
        return this.isExtraHot;
    }

    public boolean isWithStick() {
        return withStick;
    }

    @Override
    public String toString() {
        return type.getCode() + (isExtraHot ? "h" : "")
                + sugarQuantity + (withStick ? "0" : "");
    }

}
