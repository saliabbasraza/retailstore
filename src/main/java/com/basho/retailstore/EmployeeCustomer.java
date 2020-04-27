package com.basho.retailstore;

import lombok.ToString;

import java.time.LocalDate;


@ToString(callSuper = true)
public class EmployeeCustomer extends Customer {
    public EmployeeCustomer(LocalDate dateCreated) {
        super(dateCreated);
    }
}
