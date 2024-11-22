package edu.icet.controller;

import edu.icet.dto.Order;
import edu.icet.dto.RequestOrder;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Order> getAll() {
        return service.getAll();
    }

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody RequestOrder requestOrder) {
        service.placeOrder(requestOrder.getUser(), requestOrder.getItems());
    }
}
