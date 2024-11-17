package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    @JsonIgnore
    private Order order;
    private Book book;
    private Integer qty;
    private Double price;
}
