package com.olbati.kata.coffeemachine;


import com.olbati.kata.coffeemachine.order.ChocolateOrder;
import com.olbati.kata.coffeemachine.order.CoffeeOrder;
import com.olbati.kata.coffeemachine.order.Order;
import com.olbati.kata.coffeemachine.order.TeaOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit test for simple MachineTranslator.
 */
@RunWith(MockitoJUnitRunner.class)
public class MachineTranslatorTest {

    @InjectMocks
    private MachineTranslator machineTranslator = new MachineTranslator();

    @Mock
    private ForewordMessageProcess forewordMessageProcess;

    @Test
    public void should_return_instruction_of_tea_when_order_is_tea() {
        //given

        //when
        Order order = new TeaOrder(0, new BigDecimal(1));

        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.TEA);
    }

    @Test
    public void should_return_instruction_of_coffee_when_order_is_coffee() {
        //given

        //when
        Order order = new CoffeeOrder(0, new BigDecimal(1));
        Instruction instruction = (Instruction) machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.COFFEE);
    }

    @Test
    public void should_return_instruction_of_chocolate_when_order_is_chocolate() {
        //given

        //when
        Order order = new ChocolateOrder(0, new BigDecimal(1));
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.CHOCOLATE);
    }

    @Test
    public void should_return__instruction_of_chocolate_with_one_sugar_when_order_is_chocolate_with_one_sugar() {
        //given

        //when
        Order order = new ChocolateOrder(1, new BigDecimal(1));
        Instruction instruction = (Instruction) machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.CHOCOLATE);
        assertThat(instruction.getSugarQuantity()).isEqualTo(1);
    }

    @Test
    public void should_return_instruction_of_coffee_with_two_sugar_and_stick_when_order_is_coffee_with_two_sugar() {
        //given

        //when
        Order order = new CoffeeOrder(2, new BigDecimal(1));
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.COFFEE);
        assertThat(instruction.getSugarQuantity()).isEqualTo(2);
        assertThat(instruction.isWithStick()).isTrue();

    }

    @Test
    public void should_return_message_instruction__when_order_is_message() {
        //given
        String msg = "default message";
        when(forewordMessageProcess.sendsMsg(anyString())).thenReturn("M:default message");

        //when
        String instruction = machineTranslator.sendMessage(msg);

        //then
        assertThat(instruction.charAt(0)).isEqualTo('M');
        assertThat(instruction.substring(2, instruction.length())).isEqualTo("default message");
    }


    @Test
    public void should_return_tea_instruction_only_if_money_enough() {

        //given
        Order order = new TeaOrder(1, BigDecimal.valueOf(1));

        //when
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.TEA);
    }

    @Test
    public void should_return_coffee_instruction_if_money_enough() {

        //given
        Order order = new CoffeeOrder(1, new BigDecimal(1));

        //when
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.COFFEE);
    }

    @Test
    public void should_return_tea_instruction_if_money_enough_when_tea_order() {

        //given
        Order order = new TeaOrder(1, new BigDecimal(0.4));

        //when
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.TEA);
    }

    @Test
    public void should_send_message_instruction_if_money_not_enough_for_order_coffee() {

        //given
        Order order = new CoffeeOrder(1, new BigDecimal(0.1));
        //when
        machineTranslator.translate(order);
        //then

        verify(forewordMessageProcess, times(1)).sendsMsg(anyString());
        // assertThat()
    }

    @Test
    public void should_send_message_contains_a_missing_amount_when_not_enough_money_for_order_coffee() {
        //given
        String msg = "Money is not enough, missing on euro , 0.50";
        Order order = new CoffeeOrder(1, new BigDecimal(0.1));
        //when
        machineTranslator.translate(order);
        //then

        verify(forewordMessageProcess, times(1)).sendsMsg(msg);

        // assertThat()
    }


}