package co.edu.uptc;

import java.io.FileNotFoundException;
import java.io.IOException;

import co.edu.uptc.controllers.CsvController;
import co.edu.uptc.controllers.WriteJSON;
import co.edu.uptc.controllers.WriteTXT;
import co.edu.uptc.controllers.WriteXML;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CsvController cs = new CsvController();

        WriteTXT txt = new WriteTXT();
        txt.writeTXT(cs.unpackCsv());

        WriteXML xml = new WriteXML();
        xml.writeXML(cs.unpackCsv());

        WriteJSON json = new WriteJSON();
        json.writeJSON(cs.unpackCsv());
    }
}