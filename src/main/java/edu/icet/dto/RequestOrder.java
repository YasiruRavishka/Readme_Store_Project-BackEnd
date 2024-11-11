package edu.icet.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestOrder {
    private User user;
    private List<OrderItem> items;
}
