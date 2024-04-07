package co.edu.uptc.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.models.Info;
import co.edu.uptc.models.State;
import co.edu.uptc.services.PropertiesService;

public class WriteJSON {

    private PropertiesService p = new PropertiesService();

    public void writeJSON(ArrayList<Info> infoList) {
        File outputFile = new File(p.getProperties("file_outputStates"));
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            List<State> uniqueStates = extractUniqueStates(infoList);
            writeToJSON(uniqueStates, outputFile);
            System.out.println("States File saved in " + p.getProperties("file_outputStates"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<State> extractUniqueStates(ArrayList<Info> infoList) {
        Set<Integer> stateCodes = new HashSet<>();
        List<State> uniqueStates = new ArrayList<>();
        for (Info info : infoList) {
            State state = info.getState();
            if (!stateCodes.contains(state.getStateCode())) {
                uniqueStates.add(state);
                stateCodes.add(state.getStateCode());
            }
        }
        return uniqueStates;
    }

    private void writeToJSON(List<State> states, File outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputFile, states);
    }
}
