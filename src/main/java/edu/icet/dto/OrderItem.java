package edu.icet.dto;

import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    private Order order;
    private Book book;
    private Integer quantity;
    private Double price;
}
