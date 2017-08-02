package com.olbati.kata.coffeemachine;

import com.olbati.kata.coffeemachine.order.Order;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class MachineTranslator {

    public Instruction translate(Order order) {
        DrinkType drinkType = order.getDrinkType();
        int sugarQuantity = order.getSugarQuantity();
        boolean stickCode = order.getSugarQuantity() > 0;
        return new Instruction(drinkType, sugarQuantity, stickCode);
    }


    public String sendMessage(String msg) {
        String instructionMsg = "M:".concat(msg);
        return instructionMsg;
    }
}

