package edu.icet.service;

import edu.icet.dto.Order;
import edu.icet.dto.OrderItem;
import edu.icet.dto.User;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    void placeOrder(User user, List<OrderItem> items);
}
