package Ryhmatoo;

import java.util.*;
import java.io.File;


public class testKlass {
    public static void main(String[] args) throws Exception {
        List<Rahakott> rahakotid = new ArrayList<>();
        File andmebaas = new File("rahakotid.txt");
        Scanner scan = new Scanner(System.in);

        failistListi.failistList(andmebaas, rahakotid);


        while (true) {
            System.out.print("Lisa / näita / kustuta / peata / teisenda: ");
            String s = scan.nextLine().toLowerCase();

            if (!s.equals("peata")) {
                if (s.equals("näita")) {
                    tegevusNäita.näita(rahakotid);
                } else if (s.equals("lisa")) {
                    tegevusLisa.lisa(andmebaas, rahakotid, scan);
                } else if (s.equals("kustuta")) {
                    tegevusKustuta.kustuta(rahakotid, andmebaas, scan);
                }
                else if (s.equals("teisenda")) {
                    tegevusTeisenda.teisenda(rahakotid, scan);
                }
            }
            else {
                System.out.println("Programm suletakse");
                System.exit(0);
                break;
            }
        }
    }
}

