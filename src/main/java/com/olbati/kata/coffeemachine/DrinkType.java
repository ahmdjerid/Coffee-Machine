package com.olbati.kata.coffeemachine;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public enum DrinkType {
    COFFEE('C'),
    TEA('T'),
    CHOCOLATE('H');

    private char code;

    DrinkType(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
