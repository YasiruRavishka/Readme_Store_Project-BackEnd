package edu.icet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "img_src")
    private String imgSrc;

    @Column(nullable = false)
    private String name;

    private String description;
    private String author;
    private String publisher;
    private double price;

    @Column(name = "qty_on_hand")
    private int qtyOnHand;

    @Column(name = "is_disable")
    private boolean isDisable;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id")
    private List<OrderItemEntity> orderItems;
}
