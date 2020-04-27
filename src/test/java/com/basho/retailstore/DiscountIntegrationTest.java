package com.basho.retailstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

class DiscountIntegrationTest {

    private static Bill bill;

    @BeforeEach
    void init() {
        bill = Mockito.mock(Bill.class);
    }

    @Test
    void whenNewCustomer_createDiscount_ShouldReturn_StandardDiscount() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new Customer(LocalDate.now()));

        Discount discount = Discount.createDiscount(bill);

        Assertions.assertAll("discount",
                () -> Assertions.assertEquals(StandardDiscount.class, discount.getClass()),
                () -> Assertions.assertEquals(5, discount.getDiscount()));
    }

    @Test
    void whenOldCustomer_createDiscount_ShouldReturn_StandardPlusLoyaltyDiscount() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(200));
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new Customer(LocalDate.now().minusYears(2).minusDays(1)));

        Discount discount = Discount.createDiscount(bill);

        Assertions.assertAll("discount",
                () -> Assertions.assertEquals(StandardDiscount.class, discount.getClass()),
                () -> Assertions.assertEquals(15, Double.valueOf(discount.getDiscount()).intValue())
        );
    }

    @Test
    void whenAffiliateCustomer_createDiscount_ShouldReturn_StandardPlusAffiliateDiscount() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(200));
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new AffiliateCustomer(LocalDate.now()));

        Discount discount = Discount.createDiscount(bill);

        Assertions.assertAll("discount",
                () -> Assertions.assertEquals(StandardDiscount.class, discount.getClass()),
                () -> Assertions.assertEquals(20, Double.valueOf(discount.getDiscount()).intValue())
        );
    }

    @Test
    void whenEmployeeCustomer_createDiscount_ShouldReturn_StandardPlusEmployeeDiscount() {
        Mockito.when(bill.getTotal()).thenReturn(Double.valueOf(200));
        Mockito.when(bill.getNonGroceryTotal()).thenReturn(Double.valueOf(100));
        Mockito.when(bill.getCustomer()).thenReturn(new EmployeeCustomer(LocalDate.now()));

        Discount discount = Discount.createDiscount(bill);

        Assertions.assertAll("discount",
                () -> Assertions.assertEquals(StandardDiscount.class, discount.getClass()),
                () -> Assertions.assertEquals(40, Double.valueOf(discount.getDiscount()).intValue())
        );
    }

}