package com.basho.retailstore;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class Bill {
    private final Customer customer;
    private final double groceryTotal;
    private final double nonGroceryTotal;

    public Bill(Customer customer, double groceryTotal, double nonGroceryTotal) {
        this.customer = customer;
        this.groceryTotal = groceryTotal;
        this.nonGroceryTotal = nonGroceryTotal;
    }

    public double getTotal() {
        return this.groceryTotal + this.nonGroceryTotal;
    }

    public double getNetPayable() {
        return this.getTotal() - this.getDiscount();
    }

    private double getDiscount() {
        return Discount.createDiscount(this).getDiscount();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", Total=" + getTotal() +
                ", TotalDiscount=" + getDiscount() +
                ", TotalPayable=" + getNetPayable() +
                ", groceryTotal=" + groceryTotal +
                ", nonGroceryTotal=" + nonGroceryTotal +
                '}';
    }
}
