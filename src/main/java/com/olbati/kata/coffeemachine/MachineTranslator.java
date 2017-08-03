package com.olbati.kata.coffeemachine;

import com.olbati.kata.coffeemachine.order.Order;
import com.olbati.kata.coffeemachine.products.IProduct;

import java.math.BigDecimal;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 01/08/2017
 */
public class MachineTranslator {


    private ForewordMessageProcess forewordMessageProcess = new ForewordMessageProcessImpl();

    public String command(Order order) {

        if (isEnoughMoney(order)) {
            return getInstruction(order.product, order.getSugarQuantity());

        } else {
            String missingMoney = order
                    .getAmountMoney()
                    .subtract(order.product.getPrice())
                    .abs().setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toString();

            sendMessage("Money is not enough, missing on euro , " + missingMoney);

            return "";
        }

    }

    public String getInstruction(IProduct product, int sugarQuantity) {
        String sugarCode;
        switch (sugarQuantity) {
            case 0:
                sugarCode = "::";
                break;
            case 1:
                sugarCode = ":1:0";
                break;
            default:
                sugarCode = ":2:0";
        }

        return product.getCode() + sugarCode;
    }

    private boolean isEnoughMoney(Order order) {
        BigDecimal amountMoney = order.amountMoney;
        BigDecimal price = order.product.getPrice();

        return amountMoney.compareTo(price) == 1 || amountMoney.compareTo(price) == 0;
    }


    public String sendMessage(String msg) {
        return forewordMessageProcess.sendsMsg(msg);
    }
}

