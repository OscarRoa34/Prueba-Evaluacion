package co.edu.uptc.models;

public class Info {

    private Region region;
    private State state;
    private City city;

    public Info(Region region, State state, City city) {
        this.region = region;
        this.state = state;
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public State getState() {
        return state;
    }

    public City getCity() {
        return city;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
