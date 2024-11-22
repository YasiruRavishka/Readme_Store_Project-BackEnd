package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.icet.util.UserType;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private UserType type;
    private Boolean isDisable;
    @JsonManagedReference
    private List<Order> orders;

    @JsonIgnore
    public User setDisable(Boolean disable) {
        isDisable = disable;
        return this;
    }
}
