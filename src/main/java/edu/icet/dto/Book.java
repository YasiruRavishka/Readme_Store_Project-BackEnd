package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("isDisable")
    private boolean isDisable;
}
