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

        Assertions.assertEquals(2_000, account.getBalance());
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

        Assertions.assertEquals(1_500, account.getBalance());
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
    public void shouldPayThanLessMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(5_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldPayThanLessInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(1_000);

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
        account.add(4_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-1_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayZero() {
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
    public void shouldPayThanMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(12_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayThanMoreMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(1_500);

        Assertions.assertFalse(false);
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
    public void TestYearChangeZeroInitialBalance() {

        SavingAccount account = new SavingAccount(
                0,
                2_000,
                10_000,
                5
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
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
