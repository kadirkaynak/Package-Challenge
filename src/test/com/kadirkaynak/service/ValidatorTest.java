package com.kadirkaynak.service;


import com.kadirkaynak.exception.ItemException;
import com.kadirkaynak.exception.PackageException;
import com.kadirkaynak.model.Item;
import com.kadirkaynak.model.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @Test
    public void Given_Item_When_Validator_Then_DoNothing() throws ItemException {
        // given
        Item newItem = Item.builder().itemId("1").weight(99).value(99).build();

        // when
        Validator.itemControl(1, newItem);

        // then
        assertTrue(true);
    }

    @Test
    public void Given_ItemHighWeight_When_Validator_Then_ThrowException() {
        // given
        Item newItem = Item.builder().itemId("1").weight(101).value(99).build();

        // when

        // then
        Assertions.assertThrows(ItemException.class, () ->{Validator.itemControl(1, newItem);});
    }

    @Test
    public void Given_ItemHighValue_When_Validator_Then_ThrowException() {
        // given
        Item newItem = Item.builder().itemId("1").weight(99).value(101).build();

        // when

        // then
        Assertions.assertThrows(ItemException.class, () ->{Validator.itemControl(1, newItem);});
    }

    @Test
    public void Given_Package_When_Validator_Then_DoNothing() throws PackageException {
        // given
        Item newItem = Item.builder().itemId("1").weight(99).value(99).build();
        Package newPackage = Package.builder().maxWeight(99).items(Arrays.asList(newItem)).build();

        // when
        Validator.packageControl(1, newPackage);

        // then
        assertTrue(true);
    }

    @Test
    public void Given_PackageHighWeight_When_Validator_Then_ThrowError() {
        // given
        Item newItem = Item.builder().itemId("1").weight(99).value(99).build();
        Package newPackage = Package.builder().maxWeight(101).items(Arrays.asList(newItem)).build();

        // when

        // then
        Assertions.assertThrows(PackageException.class, () ->{Validator.packageControl(1, newPackage);});
    }

    @Test
    public void Given_PackageMuchItems_When_Validator_Then_ThrowError() {
        // given
        Item newItem = Item.builder().itemId("1").weight(99).value(99).build();
        List<Item> items = Collections.nCopies( 16, newItem);
        Package newPackage = Package.builder().maxWeight(101).items(items).build();

        // when

        // then
        Assertions.assertThrows(PackageException.class, () ->{Validator.packageControl(1, newPackage);});
    }
}