package com.ps.DAO.interfaces;

import com.ps.Models.Transaction;

import java.util.List;

public interface TransactionDAOInt {

    void addTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getAllTransactions();
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int id);
}
