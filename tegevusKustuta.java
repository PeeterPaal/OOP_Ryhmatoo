package Ryhmatoo;

import java.io.FileWriter;
import java.util.*;
import java.io.File;

public class tegevusKustuta {
    public static void kustuta(List<Rahakott> rahakotid, File andmebaas, Scanner scan) throws Exception{
        String oigeKood = "";

        boolean eemalda = false;
        while (oigeKood.equals("")) {
            System.out.print("Sisestage rahakoti tunnuskood: ");
            String kood = scan.nextLine();
            for (Iterator<Rahakott> i = rahakotid.listIterator(); i.hasNext(); ) {
                Rahakott rahakott = i.next();
                if (Integer.toString(rahakott.getTunnusNumber()).equals(kood)) {
                    System.out.print("Olete kindel, et soovite rahakoti tunnusnumbriga " + kood + " kustutada? (Y/N) ");
                    String yesOrNo = scan.nextLine().toUpperCase();
                    if (yesOrNo.equals("Y")) {
                        eemalda = true;
                        oigeKood = kood;
                        break;
                    }
                    else if (yesOrNo.equals("N")) {
                        oigeKood = kood;
                        break;
                    }

                    else {
                        System.out.println("Tundmatu valik, töö lõpetatakse.");
                        oigeKood = kood;
                        break;
                    }
                }
            }
            if (oigeKood.equals("")) {
                System.out.println("Sellise tunnuskoodiga rahakotti ei leidu, proovige uuesti");
            }
        }

        if (eemalda) {
            for (Rahakott rahakott : rahakotid) {
                if (Integer.toString(rahakott.getTunnusNumber()).equals(oigeKood)) {
                    rahakotid.remove(rahakott);
                    break;
                }
            }
        }
        Collections.sort(rahakotid);

        FileWriter kirjutaja = new FileWriter(andmebaas);
        FailiKirjutaja.kirjutaja(rahakotid, kirjutaja);
    }
}
