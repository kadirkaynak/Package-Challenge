package com.kadirkaynak.util;

import com.kadirkaynak.model.Item;

import java.util.List;
import java.util.stream.Collectors;

import static com.kadirkaynak.constant.Constant.NO_POSSIBLE_COMBINATION;

public class Utilities {
    public static String formatter(List<Item> items) {
        return items.isEmpty() ?
                NO_POSSIBLE_COMBINATION :
                items.stream().map(Item::getItemId).collect(Collectors.joining(", "));
    }
}
