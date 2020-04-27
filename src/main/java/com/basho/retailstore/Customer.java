package com.basho.retailstore;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class Customer {
    protected final LocalDate dateCreated;

    public Customer(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
