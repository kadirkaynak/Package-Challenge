package com.kadirkaynak.service;

import com.kadirkaynak.exception.ItemException;
import com.kadirkaynak.exception.PackageException;
import com.kadirkaynak.model.Item;
import com.kadirkaynak.model.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.kadirkaynak.service.Parser.parseLine;
import static com.kadirkaynak.service.Parser.readInputFile;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void Given_InputText_When_ParseLine_Then_ReturnPackage() throws ItemException, PackageException {
        // given
        String inputText = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";

        // when
        Package aPackage = parseLine(1, inputText);

        // then
        assertAll(
                () -> assertEquals(81, aPackage.getMaxWeight()),
                () -> assertEquals(Item.builder().itemId("1").weight(53.38).value(45).build(), aPackage.getItems().get(0))
        );
    }

    @Test
    public void Given_Text_When_ReadFile_Then_ReturnPackages() throws ItemException, PackageException, IOException {
        // given
        ClassLoader classLoader = getClass().getClassLoader();
        File inputPath = new File(classLoader.getResource("sampleInput.txt").getFile());

        // when
        List<Package> packages = readInputFile(inputPath.getPath());

        // then
        assertNotEquals(0, packages.size());
    }

    @Test
    public void Given_Text_When_ReadFile_Then_ThrowException() {
        // given

        // when

        // then
        Assertions.assertThrows(FileNotFoundException.class, () ->{readInputFile("");});
    }

}