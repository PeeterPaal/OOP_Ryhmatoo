package Ryhmatoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Andmed {
    List<Rahakott> rahakotid = new ArrayList<>();
    java.io.File andmebaas = new java.io.File("C:\\Users\\Kristjan\\Desktop\\rahakotid.txt");

    public void loeFail() {
        if (andmebaas.exists())
            System.out.println("Andmebaas eksisteerib, loen...");
        else
            System.out.println("Andmebaasi ei eksisteeri.");
    }

    public List<Rahakott> näitaRahakotte() throws Exception {
        try (java.util.Scanner sc = new java.util.Scanner(andmebaas, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String tükid[] = rida.split(" ");
                Rahakott rahakott = new Rahakott(Integer.parseInt(tükid[0]), tükid[1], tükid[2], Double.parseDouble(tükid[3]));
                rahakotid.add(rahakott);
                System.out.println(rahakott);

            }
        }
        return rahakotid;
    }

    public void lisaRahakott(Rahakott rahakott) throws Exception {
        FileWriter kirjutaja = new FileWriter(andmebaas);
        try (java.util.Scanner sc = new java.util.Scanner(andmebaas, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                kirjutaja.write(Integer.toString(rahakott.getTunnusNumber()) + " " +
                                    rahakott.getOmanikuNimi() + " " +
                                    rahakott.getValuutaNimi() + " " +
                                    Double.toString(rahakott.getValuutaKogus()));
                kirjutaja.close();
            }
        }
    }
}
