package edu.icet.service;

import edu.icet.dto.User;
import edu.icet.util.UserType;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

    User searchUserById(Integer id);

    User searchUserByEmail(String email);

    User getValidUser(String email, String password);

    List<UserType> getAllTypes();
}
