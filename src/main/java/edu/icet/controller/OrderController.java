package edu.icet.controller;

import edu.icet.dto.RequestOrder;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/place")
    public void placeOrder(@RequestBody RequestOrder requestOrder) {
        service.placeOrder(requestOrder.getUser(), requestOrder.getItems());
    }
}
