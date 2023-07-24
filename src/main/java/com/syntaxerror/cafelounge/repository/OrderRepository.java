package com.syntaxerror.cafelounge.repository;

import java.util.List;

import com.syntaxerror.cafelounge.dto.OrderDto;

public interface OrderRepository {
    List<OrderDto> getAllOrders();

    List<OrderDto> getOrdersByCustomerId(int customerId);

}
