package com.tlhongpk.banking.model;

import java.math.BigDecimal;


public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;

    public BankAccount(String accountNumber, String accountHolderName, BigDecimal balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolderName == null || accountHolderName.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }

        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative or null");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }
        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance = balance.subtract(amount);
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

