package com.ps;

import com.ps.Models.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    ArrayList<Transaction> transacationLibrary = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

   public void display(){
        String input;
        do {
            System.out.println("\n Welcome to the Online Accounting Ledger System ! \n");
            System.out.println("\tD) Add Deposit");
            System.out.println("\tP) Make a Payment");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit");

            input = scanner.nextLine().toUpperCase();

            switch (input){
                case "D":
                    System.out.println("place holder");
                    break;
                case "P":
                    System.out.println("place holder");
                    break;
                case "L":
                    System.out.println("place holder");
                    break;
                case "X":
                    System.out.println("place holder");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!input.equals("X"));
        scanner.close();
    }
}
