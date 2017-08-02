package com.olbati.kata.coffeemachine;

import com.olbati.kata.coffeemachine.order.Order;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class MachineTranslator {


    private ForewordMessageProcess forewordMessageProcess = new ForewordMessageProcessImpl();

    public Instruction translate(Order order) {
        Instruction instruction = null;
        if (isEnoughMoney(order.getAmountMoney(), order.getDrinkType().getPrice())) {
            Boolean extraHot = order.isExtraHot();
            DrinkType drinkType = order.getDrinkType();
            int sugarQuantity = order.getSugarQuantity();
            boolean stickCode = order.getSugarQuantity() > 0;
            instruction = new Instruction(drinkType, sugarQuantity, stickCode, extraHot);

        } else {
            String missingMoney = order.getAmountMoney().
                    subtract(order.getDrinkType().getPrice())
                    .abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            sendMessage("Money is not enough, missing on euro , " + missingMoney);

        }
        return instruction;
    }


    private boolean isEnoughMoney(BigDecimal amountMoney, BigDecimal price) {
        return amountMoney.compareTo(price) == 1 || amountMoney.compareTo(price) == 0;
    }


    public String sendMessage(String msg) {
        return forewordMessageProcess.sendsMsg(msg);
    }
}

