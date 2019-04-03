package Ryhmatoo;

//faili kirjutamise meetod

import java.io.FileWriter;
import java.util.List;

public class FailiKirjutaja {
    //meetod kirjutaja vajab rahakottide listi ning kirjutajat
    public static void kirjutaja(List<Rahakott> rahakotid, FileWriter kirjutaja) throws Exception{
        kirjutaja.write("");    //algul kirjutatakse fail üle, ehk sinna kirjutatakse üks tühi sõne

        for (Rahakott rahakott : rahakotid) {   //käiakse läbi kõik listis olevad rahakotid ning kirjutatakse nende kohta info faili, iga rahakoti kohta tehakse uus rida
            kirjutaja.write(rahakott.getTunnusNumber() + " " +
                    rahakott.getOmanikuNimi() + " " +
                    rahakott.getValuutaNimi() + " " +
                    rahakott.getValuutaKogus() + " " +
                    rahakott.getKood() + "\r\n");
            kirjutaja.flush();
        }
    }
}
