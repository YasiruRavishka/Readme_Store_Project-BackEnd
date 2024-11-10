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
    private Integer id;

    @Column(name = "date_time", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_items")
    private List<OrderItemEntity> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
