package com.tlhongpk.banking;


import com.tlhongpk.banking.model.BankAccount;

public class Main {
    static void main(String[] args) {

        BankAccount account = new BankAccount(
                "10001",
                "John",
                1000.00
        );

        System.out.println("Account holder: " + account.getAccountHolderName());
        System.out.println("Balance: R" + account.getBalance());

        account.deposit(500);
        System.out.println("Balance after deposit: R" + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: R" + account.getBalance());

    }
}