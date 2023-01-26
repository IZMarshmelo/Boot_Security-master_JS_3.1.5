package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void editUser(User user);

    void removeUserById(Long id);

    boolean saveUserBol(User user);
}
