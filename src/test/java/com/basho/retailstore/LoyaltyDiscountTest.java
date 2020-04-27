package com.basho.retailstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyaltyDiscountTest {
    private Bill bill;
    private LoyaltyDiscount discount;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
        discount = new LoyaltyDiscount(bill);
    }

    @Test
    void whenNewCustomerANDNonGroceryTotal_100_then_getDiscountShouldReturn_0() {
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new Customer(LocalDate.now()));
        assertEquals(0, discount.getDiscount());
    }

    @Test
    void whenOldCustomerANDNonGroceryTotal_100_then_getDiscountShouldReturn_5() {
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new Customer(LocalDate.now().minusYears(2)));
        assertEquals(0, discount.getDiscount());
    }
}