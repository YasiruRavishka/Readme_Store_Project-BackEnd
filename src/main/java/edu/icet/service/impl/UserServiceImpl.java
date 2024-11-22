package edu.icet.service.impl;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserDao;
import edu.icet.service.EmailService;
import edu.icet.service.UserService;
import edu.icet.util.UserType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao repository;
    private final EmailService emailService;
    private final ModelMapper mapper;

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        for (UserEntity entity : repository.findAll()) {
            userList.add(mapper.map(entity, User.class));
        }
        return userList;
    }

    @Override
    public void addUser(User user) {
        try {
            repository.save(mapper.map(user, UserEntity.class));
            emailService.sendAccountCreatedSuccessEmail(user.getEmail(), user.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            repository.save(mapper.map(user, UserEntity.class));
            emailService.sendAccountPasswordChangedSuccessEmail(user.getEmail(), user.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        updateUser(searchUserById(id).setDisable(true));
    }

    @Override
    public User searchUserById(Integer id) {
        Optional<UserEntity> value = repository.findById(id);
        return value.isEmpty() ? null : mapper.map(value, User.class);
    }

    @Override
    public User searchUserByEmail(String email) {
        Optional<UserEntity> value = repository.findByEmail(email);
        return value.isEmpty() ? null : mapper.map(value, User.class);
    }

    @Override
    public User getValidUser(String email, String password) {
        Optional<UserEntity> value = repository.getValidUser(email, password);
        return value.isEmpty() ? null : mapper.map(value, User.class);
    }

    @Override
    public List<UserType> getAllTypes() {
        return Arrays.asList(UserType.values());
    }
}
