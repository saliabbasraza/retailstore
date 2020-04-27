package com.basho.retailstore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StandardDiscount extends Discount {

    private final Bill bill;

    public StandardDiscount(Bill bill) {
        this.bill = bill;
    }

    @Override
    public double getDiscount() {
        return Double.valueOf(bill.getTotal() / 100).intValue() * 5 + nextDiscount();
    }
}
