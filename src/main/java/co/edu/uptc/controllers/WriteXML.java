package co.edu.uptc.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import co.edu.uptc.models.City;
import co.edu.uptc.models.CityWrapper;
import co.edu.uptc.models.Info;
import co.edu.uptc.services.PropertiesService;

public class WriteXML {

    private PropertiesService p = new PropertiesService();

    public void writeXML(ArrayList<Info> info) {
        File outputFile = new File(p.getProperties("file_outputCities"));
        ArrayList<City> cities = extractCities(info);
        writeToXML(cities, outputFile);
        System.out.println("Archivo de ciudades guardado en " + p.getProperties("file_outputCities"));
    }

    private ArrayList<City> extractCities(ArrayList<Info> info) {
        ArrayList<City> cities = new ArrayList<>();
        for (Info element : info) {
            cities.add(element.getCity());
        }
        return cities;
    }

    private void writeToXML(ArrayList<City> cities, File outputFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CityWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            CityWrapper cityWrapper = new CityWrapper();
            cityWrapper.setCities(cities);
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            marshaller.marshal(cityWrapper, outputStream);
            outputStream.close();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

}
