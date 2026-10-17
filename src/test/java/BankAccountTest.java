
package com.tlhongpk.banking;

import com.tlhongpk.banking.model.BankAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(
                "10001",
                "John",
                new BigDecimal("1000.00")
        );

        account.deposit(new BigDecimal("500.00"));

        assertEquals(
                0,
                new BigDecimal("1500.00").compareTo(account.getBalance())
        );
    }


    @Test
    void withdrawShouldDecreaseBalance() {
        BankAccount account = new BankAccount(
                "10002",
                "Mary",
                new BigDecimal("1000.00")
        );

        account.withdraw(new BigDecimal("200.00"));

        assertEquals(
                0,
                new BigDecimal("800.00").compareTo(account.getBalance())
        );
    }

    @Test
    void withdrawalExceedingBalanceShouldNotChangeBalance() {
        BankAccount account = new BankAccount(
                "10003",
                "Alex",
                new BigDecimal("1000.00")
        );

        account.withdraw(new BigDecimal("1500.00"));

        assertEquals(
                0,
                new BigDecimal("1000.00").compareTo(account.getBalance())
        );
    }


    @Test
    void negativeDepositShouldNotChangeBalance() {
        BankAccount account = new BankAccount(
                "10004",
                "Sarah",
                new BigDecimal("1000.00")
        );

        account.deposit(new BigDecimal("-100.00"));

        assertEquals(
                0,
                new BigDecimal("1000.00").compareTo(account.getBalance())
        );
    }

    @Test
    void negativeWithdrawalShouldNotChangeBalance() {
        BankAccount account = new BankAccount(
                "10005",
                "David",
                new BigDecimal("1000.00")
        );

        account.withdraw(new BigDecimal("-200.00"));

        assertEquals(
                0,
                new BigDecimal("1000.00").compareTo(account.getBalance())
        );
    }


    @Test
    void zeroDepositShouldNotChangeBalance() {
        BankAccount account = new BankAccount(
                "10006",
                "Thabo",
                new BigDecimal("1000.00")
        );

        account.deposit(BigDecimal.ZERO);

        assertEquals(
                0,
                new BigDecimal("1000.00").compareTo(account.getBalance())
        );
    }

    @Test
    void zeroWithdrawalShouldNotChangeBalance() {
        BankAccount account = new BankAccount(
                "10007",
                "Lerato",
                new BigDecimal("1000.00")
        );

        account.withdraw(BigDecimal.ZERO);

        assertEquals(
                0,
                new BigDecimal("1000.00").compareTo(account.getBalance())
        );
    }

    @Test
    void emptyAccountNumberShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(
                        "",
                        "John",
                        new BigDecimal("1000.00")
                )
        );
    }

    @Test
    void emptyAccountHolderNameShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(
                        "10009",
                        "",
                        new BigDecimal("1000.00")
                )
        );
    }

    @Test
    void negativeInitialBalanceShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(
                        "10010",
                        "Thabo",
                        new BigDecimal("-100.00")
                )
        );
    }
}