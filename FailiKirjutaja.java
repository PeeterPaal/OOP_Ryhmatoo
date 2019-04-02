package Ryhmatoo;

import java.io.FileWriter;
import java.util.List;

public class FailiKirjutaja {
    public static void kirjutaja(List<Rahakott> rahakotid, FileWriter kirjutaja) throws Exception{


        kirjutaja.write("");

        for (Rahakott rahakott : rahakotid) {
            kirjutaja.write(rahakott.getTunnusNumber() + " " +
                    rahakott.getOmanikuNimi() + " " +
                    rahakott.getValuutaNimi() + " " +
                    rahakott.getValuutaKogus() + " " +
                    rahakott.getKood() + "\r\n");
            kirjutaja.flush();
        }
    }
}
