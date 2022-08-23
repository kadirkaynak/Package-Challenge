package com.kadirkaynak;

import com.kadirkaynak.exception.ItemException;
import com.kadirkaynak.exception.PackageException;
import com.kadirkaynak.model.Item;
import com.kadirkaynak.model.Package;
import com.kadirkaynak.service.Knapsack;
import com.kadirkaynak.service.Parser;

import java.io.IOException;
import java.util.List;

import static com.kadirkaynak.util.Utilities.formatter;

public class PackageChallengeDemo {

    public static void main(String[] args) throws ItemException, PackageException, IOException {
        if (args.length != 1){
            System.out.println("Only 1 arg should be added!");
            System.exit(1);
        }

        List<Package> packages = Parser.readInputFile(args[0]);
        for(Package pack : packages) {
            List<Item> knapsackOutput = Knapsack.knapsack(pack.getMaxWeight(), pack.getItems(), pack.getItems().size());
            System.out.println(formatter(knapsackOutput));
        }

    }
}