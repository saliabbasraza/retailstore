package com.basho.retailstore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AffiliateDiscount extends PercentageDiscount {
    private static final float DISCOUNT_RATIO = 0.1f;

    private final Bill bill;

    public AffiliateDiscount(Bill bill) {
        this.bill = bill;
    }

    @Override
    public double getDiscount() {
        return bill.getNonGroceryTotal() * DISCOUNT_RATIO + nextDiscount();
    }
}
