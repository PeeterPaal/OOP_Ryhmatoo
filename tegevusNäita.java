package Ryhmatoo;

import java.util.List;

public class tegevusNäita {
    public static void näita(List<Rahakott> rahakotid) {
        for (Rahakott rahakott : rahakotid) {
            System.out.println(rahakott.toString());
        }
    }
}
