package co.edu.uptc.models;

import java.util.Objects;

public class Region {

    private String regionName;

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Region region = (Region) o;
        return Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName);
    }

    @Override
    public String toString() {
        return regionName;
    }

}
