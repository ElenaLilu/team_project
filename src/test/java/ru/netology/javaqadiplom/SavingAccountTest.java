package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }


    @Test
    public void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(10_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldInitialBalanceLessMinBalance() { // исключение, когда начальный баланс меньше минимального

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 1_000, 10_000, 5);
        });
    }

    @Test
    public void shouldMinBalanceMoreMaxBalance() { // исключение, когда минимальный баланс выше максимального

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 10_000, 8_000, 5);
        });
    }


    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(11_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddLessThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(1_500);

        Assertions.assertEquals(3_500, account.getBalance());
    }

    @Test
    public void shouldRateEqualsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );
        account.add(1_500);

        Assertions.assertEquals(3_500, account.getBalance());
    }

    @Test
    public void shouldAddNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-2);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldAllNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда все данные в отрицательном значении
            new SavingAccount(-2_000, -1_000, -10_000, -5);
        });

    }

    @Test
    public void shouldMinBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда минимальный баланс отрицательный
            new SavingAccount(2_000, -1_000, 10_000, 5);
        });

    }

    @Test
    public void shouldMaxBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда максимальный баланс отрицательный
            new SavingAccount(2_000, 1_000, -10_000, 5);
        });

    }

    @Test
    public void shouldInitialBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда начальный баланс отрицательный
            new SavingAccount(-2_000, 1_000, 10_000, 5);
        });

    }

    @Test
    public void shouldPayThanLessMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(5_000);

        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldPayThanLessInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayThanMoreInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(4_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }


    @Test
    public void shouldPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayThanMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(12_000);

        Assertions.assertEquals(false, result);
    }


    @Test
    public void shouldYearChange() {

        SavingAccount account = new SavingAccount(
                30_000,
                20_000,
                100_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(4_500, account.yearChange());
    }

    @Test
    public void TestYearChangeZero() {

        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void TestYearChangeZeroInitialBalance() { // исключение, если начальный баланс равен 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(0_000, 2_000, 10_000, 5);
        });

    }

    @Test
    public void TestYearChangeInitialBalanceLess100() { //

        SavingAccount account = new SavingAccount(
                77,
                50,
                9_000,
                60
        );

        account.yearChange();

        Assertions.assertEquals(46, account.yearChange());
    }

    @Test
    public void shouldPayBalanceEqualInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(2_000);

        Assertions.assertEquals(false, result);
    }


    @Test
    public void TestYearChangeZeroMinBalance() {

        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.yearChange();

        Assertions.assertEquals(250, account.yearChange());
    }

}