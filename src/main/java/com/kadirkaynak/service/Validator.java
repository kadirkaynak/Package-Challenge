package com.kadirkaynak.service;

import com.kadirkaynak.model.Item;
import com.kadirkaynak.model.Package;
import com.kadirkaynak.exception.ItemException;
import com.kadirkaynak.exception.PackageException;

import static com.kadirkaynak.constant.Constant.*;

public class Validator {

    static void itemControl(long lineNum, Item newItem) throws ItemException {
        if (newItem.getWeight() > MAXIMUM_WEIGHT_OF_ITEM) {
            throw new ItemException(String.format(MAXIMUM_WEIGHT_OF_ITEM_EXCEPTION, MAXIMUM_WEIGHT_OF_ITEM), lineNum);
        }
        if (newItem.getValue() > MAXIMUM_COST_OF_ITEM) {
            throw new ItemException(String.format(MAXIMUM_COST_OF_ITEM_EXCEPTION, MAXIMUM_COST_OF_ITEM), lineNum);
        }
    }

    static void packageControl(long lineNum, Package newPackage) throws PackageException {
        if (newPackage.getItems().size() > MAXIMUM_ITEMS_OF_PACKAGE) {
            throw new PackageException(String.format(MAXIMUM_NUMBER_OF_ITEMS_EXCEPTION, MAXIMUM_ITEMS_OF_PACKAGE), lineNum);
        }
        if (newPackage.getMaxWeight() > MAXIMUM_WEIGHT_OF_PACKAGE) {
            throw new PackageException(String.format(MAXIMUM_WEIGHT_OF_PACKAGE_EXCEPTION, MAXIMUM_WEIGHT_OF_PACKAGE), lineNum);
        }
    }
}
