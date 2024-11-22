package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    @JsonBackReference
    private Order order;
    private Book book;
    private Integer qty;
    private Double price;
}
