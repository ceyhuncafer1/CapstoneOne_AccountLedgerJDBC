package com.ps.DAO;

import com.ps.DAO.interfaces.UserDAOInt;
import com.ps.Models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInt {

    private static  String URL = "jdbc:mysql://localhost:3306/userinformation";
    private static  String USER = "root";
    private static  String PASSWORD = "12345678";

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO customers (firstname, lastname, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.setString(5, user.getPassword()); // Set password
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM customers WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("password") // Get password
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE customers SET firstname = ?, lastname = ?, email = ?, phone = ?, password = ? WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.setString(5, user.getPassword()); // Set password
            pstmt.setInt(6, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM customers WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
