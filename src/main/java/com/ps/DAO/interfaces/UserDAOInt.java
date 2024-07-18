package com.ps.DAO.interfaces;

import com.ps.Models.User;

import java.util.List;

public interface UserDAOInt {
    void addUser(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);
}
