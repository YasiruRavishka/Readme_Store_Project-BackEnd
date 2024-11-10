package edu.icet.controller;

import edu.icet.dto.OrderItem;
import edu.icet.dto.User;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/place")
    public void placeOrder(@RequestBody User user, @RequestBody List<OrderItem> items) {
        service.placeOrder(user, items);
    }
}
