package com.kadirkaynak.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class Package {
    private double maxWeight;
    private List<Item> items;
}
