package co.edu.uptc.controllers;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

import co.edu.uptc.models.Info;
import co.edu.uptc.models.Region;
import co.edu.uptc.services.PropertiesService;

public class WriteTXT {

    private PropertiesService p = new PropertiesService();

    public void writeTXT(ArrayList<Info> info) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(p.getProperties("file_outputRegions")), "UTF-8"))) {
            ArrayList<Region> regions = removeDuplicates(info);
            for (Region element : regions) {
                writer.write(element.toString());
                writer.newLine();
            }
            System.out.println("Archivo de Regiones guardado en " + p.getProperties("file_outputRegions"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Region> removeDuplicates(ArrayList<Info> info) {
        HashSet<Region> uniquesSet = new HashSet<>();

        for (Info element : info) {
            uniquesSet.add(element.getRegion());
        }

        ArrayList<Region> uniques = new ArrayList<>(uniquesSet);

        return uniques;
    }
}
