package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.UserDTO;
import com.sj.libAPI.models.entities.User;
import com.sj.libAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    private PasswordEncoder _encoder = new BCryptPasswordEncoder();

    public List<User> getAllUsers() {
        return new ArrayList<>(_userRepository.findAll());
    }

    public User getUserById(UUID id) {
        return _userRepository.findById(id).orElse(null);
    }

    public void addUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        newUser.setCreatedAt(LocalDate.now());
        newUser.setPassword(_encoder.encode(newUser.getPassword()));
        _userRepository.save(newUser);
    }

    public void updateUser(UUID id, UserDTO userDTO){
        User updatedUser = new User(userDTO);
        updatedUser.setId(id);
        updatedUser.setLastUpdateDt(LocalDate.now());
        if(updatedUser.getPassword() != null){
            updatedUser.setPassword(_encoder.encode(updatedUser.getPassword()));
            _userRepository.save(updatedUser);
            return;
        }
        updatedUser.setPassword(Objects.requireNonNull(_userRepository.findById(id).orElse(null)).getPassword());
        _userRepository.save(updatedUser);
    }

    public void deleteUser(UUID id){
        _userRepository.deleteById(id);
    }

}
