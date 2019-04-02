package Ryhmatoo;

import java.io.FileWriter;
import java.util.*;
import java.io.File;

public class tegevusLisa {
    public static void lisa(File andmebaas, List<Rahakott> rahakotid, Scanner scan) throws Exception{
        FileWriter kirjutaja = new FileWriter(andmebaas);

        FailiKirjutaja.kirjutaja(rahakotid, kirjutaja);

        System.out.print("Sisestage tunnusnumber: ");
        String tunnusNumber = scan.nextLine();

        System.out.print("Sisestage omaniku nimi: ");
        String omanikuNimi = scan.nextLine();

        String oigeValuutaNimi = "";

        while (oigeValuutaNimi.equals("")) {
            System.out.print("Sisestage valuuta nimi: ");
            String valuutaNimi = scan.nextLine().toUpperCase();
            for (String el : Valuuta.lubatudValuutad) {
                if (el.equals(valuutaNimi)) {
                    oigeValuutaNimi = valuutaNimi;
                    break;
                }
            }
            if (oigeValuutaNimi.equals("")) {
                System.out.println("Sellist valuutat ei toetata, proovige uuesti");
            }
        }

        System.out.print("Sisestage valuuta kogus: ");
        String valuutaKogus = scan.nextLine();

        String kood = KoodiGeneraator.generaator();

        kirjutaja.write(tunnusNumber + " " + omanikuNimi.substring(0, 1).toUpperCase() + omanikuNimi.substring(1) + " " + oigeValuutaNimi.toUpperCase() + " " + valuutaKogus + " " + kood);
        rahakotid.add(new Rahakott(Integer.parseInt(tunnusNumber), omanikuNimi, oigeValuutaNimi, Double.parseDouble(valuutaKogus), kood));
        Collections.sort(rahakotid);
        kirjutaja.flush();
        kirjutaja.close();

    }
}
