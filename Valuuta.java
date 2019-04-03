package Ryhmatoo;

//valuuta klass ning valuuta eurodesse teisendamise meeotid

import java.util.Arrays;
import java.util.List;

public class Valuuta {
    static List<String> lubatudValuutad = Arrays.asList("BTC", "ETH");  //lubatud valuutade list

    static double BTC = 4225.92;    //valuuta väärtused eurodes, (nt 1 BTC = 4225.92 EUR)
    static double ETH = 140.59;

    //meetod valuuta2Eur vajab valuuta nime ning valuuta kogust
    public static String valuuta2Eur(String valuutaNimi, double valuutaKogus) {
        double summa = 0;   //väärtustatakse muutuja summa
        if (valuutaNimi.equals("BTC")) {    //uuritakse, mis valuutaga on tegemist ning vastavalt valuuta nimele teisendatakse valuuta eurodesse
            summa = valuutaKogus * BTC;
        }
        else if (valuutaNimi.equals("ETH")) {
            summa = valuutaKogus * ETH;
        }

        return valuutaKogus + " " + valuutaNimi + " = " + summa + " EUR";   //tagastatakse valuuta väärtus eurodes
    }
}
