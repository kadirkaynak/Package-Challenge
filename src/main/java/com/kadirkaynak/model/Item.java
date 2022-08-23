package com.kadirkaynak.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Item {
    private String itemId;
    private double weight;
    private int value;
}
