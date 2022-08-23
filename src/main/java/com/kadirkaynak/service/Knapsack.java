package com.kadirkaynak.service;

import com.kadirkaynak.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    // return maximum of two lists
    private static List<Item> max(List<Item> a, List<Item> b)
    {
        int sumValueA = a.stream().mapToInt(Item::getValue).sum();
        int sumValueB = b.stream().mapToInt(Item::getValue).sum();
        if(sumValueA > sumValueB)
            return a;
        else if(sumValueA == sumValueB){
            // return lower weight in case of same value
            double sumWeightA = a.stream().mapToDouble(Item::getWeight).sum();
            double sumWeightB = b.stream().mapToDouble(Item::getWeight).sum();
            return (sumWeightA < sumWeightB) ? a : b;
        }
        else
            return b;
    }

    // returns the objects whose values maximum, so that it can be put in a knapsack of capacity maximumWeight
    public static List<Item> knapsack(double maximumWeight, List<Item> subList, int subListSize)
    {
        // base
        if (subListSize == 0 || maximumWeight == 0)
            return new ArrayList<>();

        // if weight of the nth item is more than Knapsack capacity maximumWeight, then this item cannot be included in the optimal solution
        else if (subList.get(subListSize - 1).getWeight() > maximumWeight)
            return knapsack(maximumWeight, subList, subListSize - 1);

        // return the maximum of two cases: (1) nth item included (2) not included
        else {
            List<Item> maxSublist = knapsack(maximumWeight - subList.get(subListSize - 1).getWeight(), subList, subListSize - 1);
            maxSublist.add(subList.get(subListSize - 1));
            return max(maxSublist, knapsack(maximumWeight, subList, subListSize - 1));
        }
    }
}
