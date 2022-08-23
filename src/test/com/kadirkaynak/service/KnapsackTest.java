package com.kadirkaynak.service;

import com.kadirkaynak.model.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTest {

    @Test
    public void Given_Items_When_KnapsackEqualWeight_Then_ReturnSingleItem(){
        // given
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().itemId("1").weight(53.38).value(45).build());
        items.add(Item.builder().itemId("2").weight(88.62).value(98).build());
        items.add(Item.builder().itemId("3").weight(78.48).value(3).build());
        items.add(Item.builder().itemId("4").weight(72.30).value(76).build());
        items.add(Item.builder().itemId("5").weight(30.18).value(9).build());
        items.add(Item.builder().itemId("6").weight(46.34).value(48).build());

        // when
        List<Item> knapsack = Knapsack.knapsack(81, items, items.size());

        // then
        assertEquals("4", knapsack.get(0).getItemId());
    }

    @Test
    public void Given_Items_When_KnapsackNotEqualWeight_Then_ReturnList(){
        // given
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().itemId("1").weight(85.31).value(29).build());
        items.add(Item.builder().itemId("2").weight(14.55).value(74).build());
        items.add(Item.builder().itemId("3").weight(3.98 ).value(16).build());
        items.add(Item.builder().itemId("4").weight(26.24).value(55).build());
        items.add(Item.builder().itemId("5").weight(63.69).value(52).build());
        items.add(Item.builder().itemId("6").weight(76.25).value(75).build());
        items.add(Item.builder().itemId("7").weight(60.02).value(74).build());
        items.add(Item.builder().itemId("8").weight(93.18).value(35).build());
        items.add(Item.builder().itemId("9").weight(89.95).value(78).build());

        // when
        List<Item> knapsack = Knapsack.knapsack(75, items, items.size());

        // then
        assertEquals("2", knapsack.get(0).getItemId());
        assertEquals("7", knapsack.get(1).getItemId());
    }


    @Test
    public void Given_Items_When_KnapsackEqualWeight_Then_ReturnList(){
        // given
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().itemId("1").weight(90.72).value(13).build());
        items.add(Item.builder().itemId("2").weight(33.80).value(40).build());
        items.add(Item.builder().itemId("3").weight(43.15).value(10).build());
        items.add(Item.builder().itemId("4").weight(37.97).value(16).build());
        items.add(Item.builder().itemId("5").weight(46.81).value(36).build());
        items.add(Item.builder().itemId("6").weight(48.77).value(79).build());
        items.add(Item.builder().itemId("7").weight(81.80).value(45).build());
        items.add(Item.builder().itemId("8").weight(19.36).value(79).build());
        items.add(Item.builder().itemId("9").weight(6.76 ).value(64).build());

        // when
        List<Item> knapsack = Knapsack.knapsack(56, items, items.size());

        // then
        assertEquals("8", knapsack.get(0).getItemId());
        assertEquals("9", knapsack.get(1).getItemId());
    }

    @Test
    public void Given_Items_When_Knapsack_Then_ReturnEmptyList(){
        // given
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().itemId("1").weight(15.3).value(34).build());

        // when
        List<Item> knapsack = Knapsack.knapsack(8, items, items.size());

        // then
        assertEquals(0, knapsack.size());
    }

}