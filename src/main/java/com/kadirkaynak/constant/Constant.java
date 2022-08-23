package com.kadirkaynak.constant;

public class Constant {

    public static final String PACKAGE_WEIGHT_DELIMITER = ":";

    public static final String NO_POSSIBLE_COMBINATION = "-";

    public static final String ITEM_ID = "itemId";
    public static final String WEIGHT = "weight";
    public static final String VALUE = "value";

    public static final String SCENARIO_REGEX = "\\((?<" + ITEM_ID + ">\\d+)\\,(?<" + WEIGHT + ">\\d+(\\.\\d{1,2})?)\\,€(?<" + VALUE + ">\\d+(\\.\\d{1,2})?)\\)";

    public static final int MAXIMUM_ITEMS_OF_PACKAGE = 15;
    public static final double MAXIMUM_WEIGHT_OF_PACKAGE = 100;
    public static final double MAXIMUM_WEIGHT_OF_ITEM = 100;
    public static final int MAXIMUM_COST_OF_ITEM = 100;

    public static final String MAXIMUM_NUMBER_OF_ITEMS_EXCEPTION = "You cannot have more than %d items to choose from.";
    public static final String MAXIMUM_WEIGHT_OF_PACKAGE_EXCEPTION = "The maximum weight that a package can carry should not exceed %f.";
    public static final String MAXIMUM_WEIGHT_OF_ITEM_EXCEPTION = "The maximum weight that an item can carry should not exceed %f.";
    public static final String MAXIMUM_COST_OF_ITEM_EXCEPTION = "The maximum cost of an item should not exceed %d€.";
}
