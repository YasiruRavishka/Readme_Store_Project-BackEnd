package edu.icet.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "img_src")
    private String imgSrc;
    @Column(nullable = false)
    private String name;
    private String description;
    private String author;
    private String publisher;
    private Double price;
    @Column(name = "qty_on_hand")
    private Integer qtyOnHand;
    @Column(name = "is_disable")
    private Boolean isDisable;
}
