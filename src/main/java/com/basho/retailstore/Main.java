package com.basho.retailstore;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Bill billEmployeeCust = new Bill(new EmployeeCustomer(LocalDate.now()), 490, 500);
        System.out.println(billEmployeeCust.toString());

        Bill billAffiliateCust = new Bill(new AffiliateCustomer(LocalDate.now()), 490, 500);
        System.out.println(billAffiliateCust.toString());

        Bill billOldCust = new Bill(new Customer(LocalDate.now().minusYears(3)), 490, 500);
        System.out.println(billOldCust.toString());

        Bill billNewCust = new Bill(new Customer(LocalDate.now()), 490, 500);
        System.out.println(billNewCust.toString());
    }
}
