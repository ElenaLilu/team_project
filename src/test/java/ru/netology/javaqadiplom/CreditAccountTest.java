package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    // Constructor
    @Test void testIncorrectRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1000, 2000, -10);
        });
    }
    @Test void testIncorrectInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1000, 2000, 10);
        });
    }
    @Test void testIncorrectInitialCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1000, -2000, 10);
        });
    }

    // Pay
    @Test void testPositiveAmountPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean payResult = account.pay(500);
        Assertions.assertTrue(payResult);
        Assertions.assertEquals(500, account.getBalance());
    }
    @Test void testNegativeAmountPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean payResult = account.pay(-500);
        Assertions.assertFalse(payResult);
        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test void testOutOfLimitPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean payResult1 = account.pay(3500);
        Assertions.assertFalse(payResult1);
        Assertions.assertEquals(1000, account.getBalance());
    }

    // Add
    @Test void testPositiveAmountAdd() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean addResult = account.add(10000);
        Assertions.assertTrue(addResult);
        Assertions.assertEquals(11000, account.getBalance());
    }
    @Test void testNegativeAmountAdd() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean addResult = account.add(-10);
        Assertions.assertFalse(addResult);
        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test void testEmptyAmoundAdd() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean addResult = account.add(0);
        Assertions.assertFalse(addResult);
        Assertions.assertEquals(1000, account.getBalance());
    }
}
