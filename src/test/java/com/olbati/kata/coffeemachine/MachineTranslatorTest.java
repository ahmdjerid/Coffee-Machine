package com.olbati.kata.coffeemachine;

import com.olbati.kata.coffeemachine.order.ChocolateOrder;
import com.olbati.kata.coffeemachine.order.CoffeeOrder;
import com.olbati.kata.coffeemachine.order.Order;
import com.olbati.kata.coffeemachine.order.TeaOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple MachineTranslator.
 */
public class MachineTranslatorTest {

    private MachineTranslator machineTranslator = new MachineTranslator();


    @Test
    public void should_return_instruction_of_tea_when_order_is_tea() {
        //given

        //when
        Order order = new TeaOrder(0);
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.TEA);
    }

    @Test
    public void should_return_instruction_of_coffee_when_order_is_coffee() {
        //given

        //when
        Order order = new CoffeeOrder(0);
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.COFFEE);
    }

    @Test
    public void should_return_instruction_of_chocolate_when_order_is_chocolate() {
        //given

        //when
        Order order = new ChocolateOrder(0);
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.CHOCOLATE);
    }

    @Test
    public void should_return__instruction_of_chocolate_with_one_sugar_when_order_is_chocolate_with_one_sugar() {
        //given

        //when
        Order order = new ChocolateOrder(1);
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.CHOCOLATE);
        assertThat(instruction.getSugarQuantity()).isEqualTo(1);
    }

    @Test
    public void should_return_instruction_of_coffee_with_two_sugar_and_stick_when_order_is_coffee_with_two_sugar() {
        //given

        //when
        Order order = new CoffeeOrder(2);
        Instruction instruction = machineTranslator.translate(order);

        //then
        assertThat(instruction).isNotNull();
        assertThat(instruction.getType()).isEqualTo(DrinkType.COFFEE);
        assertThat(instruction.getSugarQuantity()).isEqualTo(2);
        assertThat(instruction.isWithStick()).isTrue();

    }

    @Test
    public void should_return_instruction_message_when_order_is_message() {
        //given
        String msg = "default message";
        //when

        String instruction = machineTranslator.sendMessage(msg);

        //then
        assertThat(instruction.charAt(0)).isEqualTo('M');
        assertThat(instruction.substring(2, instruction.length())).isEqualTo("default message");
    }


}