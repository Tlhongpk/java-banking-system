package com.tlhongpk.banking.model;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("Amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
        else if (amount <= 0) {
            balance -= amount;
        }
        else {
            System.out.println("Insufficient funds.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}

