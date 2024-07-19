package com.ps.Models;

public class Transaction {
    private int UserId;
    private String date;
    private String time;
    private String product;
    private String vendor;
    private double price;

    public Transaction(int userId, String date, String time, String product, String vendor, double price) {
        UserId = userId;
        this.date = date;
        this.time = time;
        this.product = product;
        this.vendor = vendor;
        this.price = price;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("| %-6d | %-10s | %-8s | %-15s | %-15s | %10.2f |",
                UserId, date, time, product, vendor, price);
    }
}
