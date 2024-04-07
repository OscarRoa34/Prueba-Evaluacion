package co.edu.uptc.models;

public class State {

    private String stateName;
    private int stateCode;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public State(String stateName, int stateCode) {
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

}
