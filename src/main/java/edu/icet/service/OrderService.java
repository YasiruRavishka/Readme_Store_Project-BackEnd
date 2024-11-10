package edu.icet.service;

import edu.icet.dto.OrderItem;
import edu.icet.dto.User;

import java.util.List;

public interface OrderService {
    void placeOrder(User user, List<OrderItem> items);
}
