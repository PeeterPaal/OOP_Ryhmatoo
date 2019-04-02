package Ryhmatoo;

import java.util.Arrays;
import java.util.List;

public class Valuuta {
    static List<String> lubatudValuutad = Arrays.asList("BTC", "ETH");

    static double BTC = 4225.92;
    static double ETH = 140.59;

    public static String valuuta2Eur(String valuutaNimi, double valuutaKogus) {
        double summa = 0;
        if (valuutaNimi.equals("BTC")) {
            summa = valuutaKogus * BTC;
        }
        else if (valuutaNimi.equals("ETH")) {
            summa = valuutaKogus * ETH;
        }

        return valuutaKogus + " " + valuutaNimi + " = " + summa + " EUR";
    }
}
