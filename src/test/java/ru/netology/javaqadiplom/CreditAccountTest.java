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
        boolean payResult = account.pay(300);
        Assertions.assertTrue(payResult);
        Assertions.assertEquals(700, account.getBalance());
    }
    @Test void testNegativeAmountPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean payResult = account.pay(-500);
        Assertions.assertFalse(payResult);
        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test void testOutOfLimitPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        boolean payResult1 = account.pay(4500);
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
    // Year change
    @Test void testEmptyYearChange() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test void testNegativeYearChange() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        account.pay(1500);
        // Assertions.assertEquals(-500, account.getBalance());
        Assertions.assertEquals(-50, account.yearChange());
    }

    @Test void testEmptyBalanceYearChange() {
        CreditAccount account = new CreditAccount(0, 2000, 10);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test void justForFun() {
        // TODO: удалить этот тест, изначальный баланс не может быть отрицательным, я видела
        CreditAccount account = new CreditAccount(-1000, 2000, 10);
        Assertions.assertEquals(-100, account.yearChange());
    }

}
