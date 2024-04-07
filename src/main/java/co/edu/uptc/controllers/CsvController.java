package co.edu.uptc.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import co.edu.uptc.models.City;
import co.edu.uptc.models.Info;
import co.edu.uptc.models.Region;
import co.edu.uptc.models.State;
import co.edu.uptc.services.PropertiesService;

public class CsvController {

    private PropertiesService p = new PropertiesService();

    public ArrayList<Info> unpackCsv() throws FileNotFoundException, IOException {
        ArrayList<Info> info = new ArrayList<Info>();

        try (FileInputStream fis = new FileInputStream(p.getProperties("csv_path"));
                BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                Info inf = new Info(new Region(parts[0]), new State(parts[2], Integer.parseInt(parts[1])),
                        new City(parts[4], parts[3]));

                info.add(inf);
            }
        }
        return info;
    }
}