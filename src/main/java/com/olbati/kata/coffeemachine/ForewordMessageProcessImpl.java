package com.olbati.kata.coffeemachine;

import com.olbati.kata.coffeemachine.ForewordMessageProcess;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 02/08/2017
 */
public class ForewordMessageProcessImpl implements ForewordMessageProcess {


    @Override
    public String sendsMsg(String msg) {
        return "M:".concat(msg);
    }
}
