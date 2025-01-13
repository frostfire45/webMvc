package com.frostfire.webmvc.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSvc {

    private final File inFile;

    public FileSvc(File inFile) {
        this.inFile = inFile;
    }

    public Map<Integer, List<String>> csvFileToMap(String deliminator) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        try (FileReader fr = new FileReader(inFile)) {
            int lineNumber = 0;
            String line;
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                map.put(lineNumber++, Arrays.stream(line.split(deliminator)).toList());
            }
        } catch (java.io.IOException ex) {
            System.out.println("IOException in FileSvc.csvFileToMap");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
