package com.basho.retailstore;

public abstract class PercentageDiscount extends Discount {
    @Override
    protected double nextDiscount() {
        // Since percentage discount only apply once
        return 0.0;
    }
}
