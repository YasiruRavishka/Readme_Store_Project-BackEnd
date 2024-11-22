package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private LocalDate date;
    private Double total;
    @JsonManagedReference
    private List<OrderItem> orderItems;
    @JsonBackReference
    private User user;
}
