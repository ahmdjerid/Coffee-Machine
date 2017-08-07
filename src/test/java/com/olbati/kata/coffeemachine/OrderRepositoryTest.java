package com.olbati.kata.coffeemachine;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.olbati.kata.coffeemachine.dom.order.Order;
import com.olbati.kata.coffeemachine.repositories.OrderRepository;
import com.olbati.kata.coffeemachine.dom.products.Coffee;
import com.olbati.kata.coffeemachine.dom.products.IProduct;
import com.olbati.kata.coffeemachine.dom.products.Tea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 04/08/2017
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderRepositoryTest {


    @Test
    public void should_get_three_order() {

        //given
        Multimap<IProduct, Order> orderMap = ArrayListMultimap.create();
        OrderRepository orderRepository = new OrderRepository(orderMap);

        Coffee coffee = new Coffee();
        Order coffeeOrder = new Order(0, new BigDecimal(1), coffee);
        Order coffeeOrder2 = new Order(0, new BigDecimal(1), coffee);
        orderMap.putAll(coffee, Arrays.asList(coffeeOrder2, coffeeOrder));

        Tea tea = new Tea();
        Order teaOrder = new Order(0, new BigDecimal(1), tea);
        orderMap.put(tea, teaOrder);

        //when
        List<Order> listOrders = orderRepository.findAll();

        //then
        assertThat(listOrders).hasSize(3);
    }


    @Test
    public void should_save_order() {
        //given
        OrderRepository orderRepository = new OrderRepository();

        Coffee coffee = new Coffee();
        Order coffeeOrder = new Order(0, new BigDecimal(1), coffee);
        //when
        orderRepository.save(coffeeOrder);
        List<Order> listOrders = orderRepository.findAll();

        //then
        assertThat(listOrders).hasSize(1);
    }

    @Test
    public void should_get_coffee_order() {
        //given
        Multimap<IProduct, Order> orderMap = ArrayListMultimap.create();
        OrderRepository orderRepository = new OrderRepository(orderMap);

        Coffee coffee = new Coffee();
        Order coffeeOrder = new Order(0, new BigDecimal(1), coffee);
        Order coffeeOrder2 = new Order(0, new BigDecimal(1), coffee);
        orderMap.putAll(coffee, Arrays.asList(coffeeOrder2, coffeeOrder));
        Tea tea = new Tea();
        Order teaOrder = new Order(0, new BigDecimal(1), tea);
        orderMap.put(tea, teaOrder);

        //when
        List<Order> listOrders = orderRepository.findOrdersByProduct(coffeeOrder.product);

        //then
        assertThat(listOrders).hasSize(2);
    }

    @Test
    public void should_notifer_by_email_and_message_when_() {
    //given

    //when

    //then

    }


}
