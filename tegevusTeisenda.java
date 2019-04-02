package Ryhmatoo;

import java.util.*;

public class tegevusTeisenda {
    public static void teisenda(List<Rahakott> rahakotid, Scanner scan) {
        String teisendus = "";

        while (teisendus.equals("")) {
            System.out.print("Sisestage enda tunnusnumber: ");
            String kood = scan.nextLine();
            for (Rahakott rahakott : rahakotid) {
                if (Integer.toString(rahakott.getTunnusNumber()).equals(kood)) {
                    teisendus = Valuuta.valuuta2Eur(rahakott.getValuutaNimi(), rahakott.getValuutaKogus());
                    break;
                }

            }
            if (teisendus.equals("")) {
                System.out.println("Sellise tunnusnumbriga rahakotti ei leidu, proovige uuesti");
            }
        }
        System.out.println(teisendus);
    }
}
