package com.ps;

import com.ps.DAO.TransactionDAO;
import com.ps.DAO.UserDAO;
import com.ps.DAO.interfaces.UserDAOInt;
import com.ps.Models.Transaction;
import com.ps.Models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static UserDAOInt userDAO;
    private static TransactionDAO transactionDAO;
    private static Scanner scanner = new Scanner(System.in);

    private User loggedInUser = null;

    public static void init(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/userinformation");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);

        userDAO = new UserDAO(basicDataSource);
        transactionDAO = new TransactionDAO(basicDataSource);
    }

    public void display(String[] args) {
        init(args);

        if (!login()) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        String input;
        do {
            System.out.println("\nWelcome to the Online Accounting Ledger System, " + loggedInUser.getFirstName() + "!\n");
            System.out.println("\tD) Add Deposit");
            System.out.println("\tP) Make a Payment");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit");

            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    displayLedger();
                    break;
                case "X":
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!input.equals("X"));
        scanner.close();
    }

    private boolean login() {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    private void addDeposit() {
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM:SS):");
        String time = scanner.nextLine();
        System.out.println("Enter product:");
        String product = scanner.nextLine();
        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());

        Transaction transaction = new Transaction(loggedInUser.getUserId(), date, time, product, vendor, price);
        transactionDAO.addTransaction(transaction);
        System.out.println("Deposit added successfully!");
    }

    private void makePayment() {
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM:SS):");
        String time = scanner.nextLine();
        System.out.println("Enter product:");
        String product = scanner.nextLine();
        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());

        Transaction transaction = new Transaction(loggedInUser.getUserId(), date, time, product, vendor, -price);
        transactionDAO.addTransaction(transaction);
        System.out.println("Payment made successfully!");
    }

    private void displayLedger() {
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\nLedger:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}
