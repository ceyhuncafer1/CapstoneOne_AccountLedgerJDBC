package com.ps.DAO;

import com.ps.DAO.interfaces.TransactionDAOInt;

import com.ps.Models.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements TransactionDAOInt {

    private static final String URL = "jdbc:mysql://localhost:3306/userinformation";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (user_id, date, time, product, vendor, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transaction.getUserId());
            stmt.setString(2, transaction.getDate());
            stmt.setString(3, transaction.getTime());
            stmt.setString(4, transaction.getProduct());
            stmt.setString(5, transaction.getVendor());
            stmt.setDouble(6, transaction.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        String query = "SELECT * FROM transactions WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Transaction(
                        rs.getInt("user_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("product"),
                        rs.getString("vendor"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("user_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("product"),
                        rs.getString("vendor"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        String query = "UPDATE transactions SET date = ?, time = ?, product = ?, vendor = ?, price = ? WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, transaction.getDate());
            stmt.setString(2, transaction.getTime());
            stmt.setString(3, transaction.getProduct());
            stmt.setString(4, transaction.getVendor());
            stmt.setDouble(5, transaction.getPrice());
            stmt.setInt(6, transaction.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransaction(int id) {
        String query = "DELETE FROM transactions WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
