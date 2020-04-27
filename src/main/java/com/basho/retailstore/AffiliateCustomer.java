package com.basho.retailstore;

import lombok.ToString;

import java.time.LocalDate;


@ToString(callSuper = true)
public class AffiliateCustomer extends Customer {
    public AffiliateCustomer(LocalDate dateCreated) {
        super(dateCreated);
    }
}
