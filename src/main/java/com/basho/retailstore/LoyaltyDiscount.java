package com.basho.retailstore;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class LoyaltyDiscount extends PercentageDiscount {
    private static final float DISCOUNT_RATIO = 0.05f;

    private final Bill bill;

    public LoyaltyDiscount(Bill bill) {
        this.bill = bill;
    }

    @Override
    public double getDiscount() {
        double discount = 0.0;
        if (bill.getCustomer().dateCreated.isBefore(LocalDate.now().minusYears(2))) {
            discount = bill.getNonGroceryTotal() * DISCOUNT_RATIO;
        }
        return discount + nextDiscount();
    }
}
