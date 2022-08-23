package com.kadirkaynak.service;

import com.kadirkaynak.model.Item;
import com.kadirkaynak.model.Package;
import com.kadirkaynak.exception.ItemException;
import com.kadirkaynak.exception.PackageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kadirkaynak.constant.Constant.*;
import static com.kadirkaynak.service.Validator.itemControl;
import static com.kadirkaynak.service.Validator.packageControl;

public class Parser {

    private Parser(){
    }

    public static List<Package> readInputFile(String inputPath) throws IOException, PackageException, ItemException {
        List<Package> packages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            long lineNum = -1;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if(line.isBlank()) continue;
                packages.add(parseLine(lineNum, line));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(inputPath);
        }
        return packages;
    }
    static Package parseLine(long lineNum, String line) throws PackageException, ItemException {
        // create regex pattern
        Pattern pattern = Pattern.compile(SCENARIO_REGEX);
        // get matcher objects from pattern
        Matcher matcher = pattern.matcher(line);

        List<Item> items = new ArrayList<>();

        while (matcher.find()) {
            // item creation
            Item newItem = Item.builder()
                    .itemId(matcher.group(ITEM_ID))
                    .value(Integer.parseInt(matcher.group(VALUE)))
                    .weight(Double.parseDouble(matcher.group(WEIGHT)))
                    .build();

            // item validation
            itemControl(lineNum, newItem);

            items.add(newItem);
        }

        // package creation
        Package newPackage = Package.builder()
                .maxWeight(Double.parseDouble(line.split(PACKAGE_WEIGHT_DELIMITER)[0]))
                .items(items)
                .build();

        // package validation
        packageControl(lineNum, newPackage);

        return newPackage;
    }

}
