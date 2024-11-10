package edu.icet.controller;

import edu.icet.dto.User;
import edu.icet.service.UserService;
import edu.icet.util.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user){
        service.updateUser(user);
    }

    @DeleteMapping("/delete-by-id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUserById(@RequestParam Integer id){
        service.deleteUserById(id);
    }

    @GetMapping("/search-by-id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User searchUserById(@RequestParam Integer id){
        return service.searchUserById(id);
    }

    @GetMapping("/search-by-email")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User searchUserByEmail(@RequestParam String email){
        return service.searchUserByEmail(email);
    }

    @GetMapping("/valid")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getValidUser(@RequestParam String email, @RequestParam String password){
        return service.getValidUser(email,password);
    }

    @GetMapping("/all-types")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserType> getUserAccountTypes(){
        return service.getAllTypes();
    }
}
