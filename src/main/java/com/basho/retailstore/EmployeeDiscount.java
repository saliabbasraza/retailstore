package com.basho.retailstore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeDiscount extends PercentageDiscount {
    private static final float DISCOUNT_RATIO = 0.3f;

    private final Bill bill;

    public EmployeeDiscount(Bill bill) {
        this.bill = bill;
    }

    @Override
    public double getDiscount() {
        return bill.getNonGroceryTotal() * DISCOUNT_RATIO + nextDiscount();
    }
}
