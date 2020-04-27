package com.basho.retailstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BillTest {

    @Test
    void getTotalShouldReturnSumOfGroceryAndNonGrocery() {
        Bill bill = new Bill(new Customer(LocalDate.now()), 100, 100);
        Assertions.assertEquals(200, bill.getTotal());
    }

    @Test
    void getNetPayableShouldReturnTotalMinusDiscount() {
        Bill bill = new Bill(new Customer(LocalDate.now()), 100, 100);
        Assertions.assertEquals(190, Double.valueOf(bill.getNetPayable()));
    }
}