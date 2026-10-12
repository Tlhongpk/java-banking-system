package com.tlhongpk.banking;


import com.tlhongpk.banking.model.BankAccount;
import java.math.BigDecimal;

public class Main {
    static void main(String[] args) {

        BankAccount account = new BankAccount(
                "10001",
                "John",
                new BigDecimal("1000.00")
        );

        BankAccount secondAccount = new BankAccount(
                "10002",
                "Mary",
                new BigDecimal("2500.00")

        );


        System.out.println("Account holder: " + account.getAccountHolderName());
        System.out.println("Balance: R" + account.getBalance());

        System.out.println("\nSecond account holder: " + secondAccount.getAccountHolderName());
        System.out.println("Second account balance: " + secondAccount.getBalance());

        account.deposit(null);
        System.out.println("Balance after deposit: R" + account.getBalance());

        account.withdraw(null);
        System.out.println("Balance after withdrawal: R" + account.getBalance());

        System.out.println("\n--- Testing validation ---");

        account.deposit(new BigDecimal(-500.00));
        account.withdraw(new BigDecimal(-200.00));
        account.withdraw(new BigDecimal(5000.00));

        System.out.println("Final balance: R" + account.getBalance());

        System.out.println("\n--- Testing validation ---");

        account.deposit(new BigDecimal(100.00));
        System.out.println("John's balance: R" + account.getBalance());

        System.out.println("Mary's balance: R" + secondAccount.getBalance());


        System.out.println("\n--- Testing invalidation ---");

        try {
                BankAccount invalidAccount = new BankAccount(
                "10003",
                "Alex",
                new BigDecimal("-500.00"));

        }
        catch (IllegalArgumentException e) {
                System.out.println("Account creation failed: " + e.getMessage());
        }

        System.out.println("\n--- Testing account creation ---");

        try {
            BankAccount invalidAccount = new BankAccount(
                    "",
                    "Alex",
                    new BigDecimal("500.00")
            );
        }
        catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }

        try {
            BankAccount invalidAccount = new BankAccount(
                    "10001",
                    "",
                    new BigDecimal("500.00")
            );
        }
        catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }

        try {
            BankAccount invalidAccount = new BankAccount(
                    "10005",
                    "Alex",
                    new BigDecimal("-500.00")
            );
        }
        catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }
    }
}