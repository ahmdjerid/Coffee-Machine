package com.olbati.kata.coffee.domain;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 31/07/2017
 */
public class Order {

    private String drink;
    private Integer sugar;
    private Boolean stick;


    public Order(String drink, Integer sugar) {
        this.drink = drink;
        this.sugar = sugar;
        this.stick = sugar == null;

    }

    public String getDrink() {
        return drink;
    }

    public Integer getSugar() {
        return sugar;
    }

    public Boolean getStick() {
        return stick;
    }
}
