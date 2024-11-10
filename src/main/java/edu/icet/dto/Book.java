package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String imgSrc;
    private String name;
    private String description;
    private String author;
    private String publisher;
    private Double price;
    private Integer qtyOnHand;
    private Boolean isDisable;

    @JsonIgnore
    public Book setDisable(Boolean disable) {
        isDisable = disable;
        return this;
    }
}
