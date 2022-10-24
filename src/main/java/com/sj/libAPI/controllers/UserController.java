package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.UserDTO;
import com.sj.libAPI.models.entities.User;
import com.sj.libAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService _userService;

    @GetMapping
    public List<User> getAllUsers() {
        return _userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable UUID id){
        return _userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        _userService.addUser(userDTO);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody UserDTO userDTO){
        _userService.updateUser(id, userDTO);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id){
        _userService.deleteUser(id);
    }

}
