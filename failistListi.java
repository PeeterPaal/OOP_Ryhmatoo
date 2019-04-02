package Ryhmatoo;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class failistListi {
    public static void failistList(File andmebaas, List<Rahakott> rahakotid) throws Exception{
        if (andmebaas.exists()) {
            try (Scanner sc = new Scanner(andmebaas)) {
                while (sc.hasNextLine()) {
                    String rida = sc.nextLine();
                    String[] tykid = rida.split(" ");
                    rahakotid.add(new Rahakott(Integer.parseInt(tykid[0]),
                            tykid[1].substring(0, 1).toUpperCase() + tykid[1].substring(1),
                            tykid[2].toUpperCase(), Double.parseDouble(tykid[3]),
                            tykid[4]));
                }
            }

            Collections.sort(rahakotid);
        } else {
            System.out.println("Andmebaasi ei eksisteeri.");
            System.exit(0);
        }

    }
}
