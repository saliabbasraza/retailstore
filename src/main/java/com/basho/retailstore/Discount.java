package com.basho.retailstore;

public abstract class Discount {
    private Discount next;

    public Discount linkWith(Discount next) {
        this.next = next;
        return next;
    }

    public static Discount createDiscount(Bill bill) {
        Discount discount = new StandardDiscount(bill);

        Discount next = null;
        if (bill.getCustomer() instanceof EmployeeCustomer) {
            next = discount.linkWith(new EmployeeDiscount(bill));
        } else if (bill.getCustomer() instanceof AffiliateCustomer) {
            next = discount.linkWith(new AffiliateDiscount(bill));
        }

        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(bill);
        if (next == null) {
            discount.linkWith(loyaltyDiscount);
        } else {
            next.linkWith(loyaltyDiscount);
        }

        return discount;
    }

    protected double nextDiscount() {
        if (next == null) {
            return 0.0;
        }
        return next.getDiscount();
    }

    public abstract double getDiscount();
}
