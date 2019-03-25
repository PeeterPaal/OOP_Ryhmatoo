package Ryhmatoo;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class testKlass {
    public static void main(String[] args) throws Exception {
        List<Rahakott> rahakotid = new ArrayList<>();
        java.io.File andmebaas = new java.io.File("rahakotid.txt");
        Scanner scan = new Scanner(System.in);

        System.out.println("lisa/näita: ");
        String s = scan.nextLine();

        if (s != "peata") {
            if (s == "näita") {
                if (andmebaas.exists()) {
                    System.out.println("Andmebaas eksisteerib, loen...");
                    try (java.util.Scanner sc = new java.util.Scanner(andmebaas, "UTF-8")) {
                        while (sc.hasNextLine()) {
                            String rida = sc.nextLine();
                            String tükid[] = rida.split(" ");
                            Rahakott rahakott = new Rahakott(Integer.parseInt(tükid[0]), tükid[1], tükid[2], Double.parseDouble(tükid[3]));
                            rahakotid.add(rahakott);
                            System.out.println(rahakott);
                        }
                    }
                } else {
                    System.out.println("Andmebaasi ei eksisteeri.");
                    java.lang.System.exit(0);
                }
            } else if (s == "lisa") {
                FileWriter kirjutaja = new FileWriter(andmebaas, true);
                try (java.util.Scanner sc = new java.util.Scanner(andmebaas, "UTF-8")) {
                    while (sc.hasNextLine()) {
                        String rida = sc.nextLine();
                        String tükid[] = rida.split(" ");
                        Rahakott rahakott = new Rahakott(Integer.parseInt(tükid[0]), tükid[1], tükid[2], Double.parseDouble(tükid[3]));
                        kirjutaja.write(Integer.toString(rahakott.getTunnusNumber()) + " " +
                                rahakott.getOmanikuNimi() + " " +
                                rahakott.getValuutaNimi() + " " +
                                Double.toString(rahakott.getValuutaKogus()));
                        kirjutaja.flush();
                    }
                }
                Scanner lisamine = new Scanner(System.in);
                System.out.println("sisestage tunnusnumber, omanikunimi, valuutanimi ja valuutakogus: ");
                String lisa = scan.nextLine();
                String lisaSplititud[] = lisa.split(" ");
                kirjutaja.write(lisaSplititud[0] + " " + lisaSplititud[1] + " " + lisaSplititud[2] + " " + lisaSplititud[3]);
                kirjutaja.flush();
                kirjutaja.close();
            }
        } else {
            java.lang.System.exit(0);
        }
    }
}
