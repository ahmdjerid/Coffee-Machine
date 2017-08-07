package com.olbati.kata.coffeemachine.services;

import com.olbati.kata.coffeemachine.dto.DrinkSoldDetailsDto;
import com.olbati.kata.coffeemachine.repositories.IOrderRepository;
import com.olbati.kata.coffeemachine.dom.order.Order;
import com.olbati.kata.coffeemachine.dom.products.IProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmed Jerid <ahmed.jerid@olbati.com>
 *         Date: 04/08/2017
 */
public class OrderReport implements IOrderReport {

    private IOrderRepository orderRepository;

    public OrderReport(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public DrinkSoldDetailsDto getReportDetails(IProduct product) {

        List<Order> orders = orderRepository.findOrdersByProduct(product);

        if (orders.isEmpty())
            return new DrinkSoldDetailsDto(product, 0, BigDecimal.ZERO);
        else {

            int quantity = orders.size();

            BigDecimal amount = product.getPrice().multiply(new BigDecimal(quantity));


            return new DrinkSoldDetailsDto(product, quantity, amount);
        }


    }

    @Override
    public List<DrinkSoldDetailsDto> getReportDetails() {

        List<DrinkSoldDetailsDto> reportDetails = new ArrayList<>();

        List<IProduct> productTypes = orderRepository.findProductTypes();

        productTypes.forEach(type -> {
            reportDetails.add(getReportDetails(type));
        });
        return reportDetails;

    }
}
