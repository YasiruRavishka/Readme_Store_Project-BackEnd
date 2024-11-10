package edu.icet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id")
    private List<OrderItemEntity> orderItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
