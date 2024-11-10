package edu.icet.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private LocalDate date;
    private Double total;
    private List<OrderItem> orderItems;
    private User user;
}
