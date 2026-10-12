package com.tlhongpk.banking.model;

import java.math.BigDecimal;


public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;

    public BankAccount(String accountNumber, String accountHolderName, BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative or null");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
        else {
            System.out.println("Amount must be greater than 0.");
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

