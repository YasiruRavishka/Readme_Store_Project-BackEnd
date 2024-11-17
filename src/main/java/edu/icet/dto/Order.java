package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private LocalDate date;
    private Double total;
    private List<OrderItem> orderItems;
    @JsonIgnore
    private User user;
}
