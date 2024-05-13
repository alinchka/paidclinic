package com.paidclinic.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem
{
    private String productName;
    private int quantity;
    private int cost;
}
