package com.basho.retailstore;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardDiscountTest {
    private Bill bill;
    private StandardDiscount discount;

    @BeforeAll
    static void initAll() {

    }

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        discount = new StandardDiscount(bill);
    }

    @Test
    void whenTotal_100_then_getDiscountShouldReturn_5() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(100));
        assertEquals(5, discount.getDiscount());
    }

    @Test
    void whenTotal_99_then_getDiscountShouldReturn_0() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(99));
        assertEquals(0, discount.getDiscount());
    }
}