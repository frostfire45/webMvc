package com.frostfire.webmvc.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileSvcTest {
    private String filePath =
            "C:\\Users\\d.huskey\\IdeaProjects\\webMvc\\webMvc\\src\\test\\FileServiceTestResources\\CsvTest2.csv";
//    @BeforeEach
//    void setUp() {
//        java.io.File file = new java.io.File(filePath);
//        try () {
//            java.io.
//        }
//        catch (java.io.IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void csvFileToMap() {
        FileSvc fs = new FileSvc(new java.io.File(filePath));
        Map<Integer, List<String>> map = fs.csvFileToMap(",");
        assertTrue(map.size() < 5);
        System.out.println(map);
    }
}