package co.edu.uptc.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Cities")
public class CityWrapper {
    private List<City> cities;

    public CityWrapper() {
    }

    public CityWrapper(List<City> cities) {
        this.cities = cities;
    }

    @XmlElement(name = "City")
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
