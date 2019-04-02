package Ryhmatoo;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class testKlass {
    public static void main(String[] args) throws Exception {
        List<Rahakott> rahakotid = new ArrayList<>();
        File andmebaas = new File("rahakotid.txt");
        Scanner scan = new Scanner(System.in);

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
        } else {
            System.out.println("Andmebaasi ei eksisteeri.");
            java.lang.System.exit(0);
        }


        while (true) {
            System.out.print("Lisa / näita / kustuta / peata: ");
            String s = scan.nextLine().toLowerCase();
            if (!s.equals("peata")) {
                if (s.equals("näita")) {
                    for (Rahakott rahakott : rahakotid) {
                        System.out.println(rahakott.toString());
                    }
                } else if (s.equals("lisa")) {
                    FileWriter kirjutaja = new FileWriter(andmebaas);

                    FailiKirjutaja.kirjutaja(rahakotid, kirjutaja);

                    System.out.print("Sisestage tunnusnumber: ");
                    String tunnusNumber = scan.nextLine();

                    System.out.print("Sisestage omaniku nimi: ");
                    String omanikuNimi = scan.nextLine();

                    System.out.print("Sisestage valuuta nimi: ");
                    String valuutaNimi = scan.nextLine();

                    System.out.print("Sisestage valuuta kogus: ");
                    String valuutaKogus = scan.nextLine();

                    String kood = KoodiGeneraator.generaator();

                    kirjutaja.write(tunnusNumber + " " + omanikuNimi.substring(0, 1).toUpperCase() + omanikuNimi.substring(1) + " " + valuutaNimi.toUpperCase() + " " + valuutaKogus + " " + kood);
                    rahakotid.add(new Rahakott(Integer.parseInt(tunnusNumber), omanikuNimi, valuutaNimi, Double.parseDouble(valuutaKogus), kood));
                    kirjutaja.flush();
                    kirjutaja.close();
                } else if (s.equals("kustuta")) {
                    boolean eemalda = false;
                    System.out.println("Sisestage rahakoti tunnuskood: ");
                    String kood = scan.nextLine();
                    for (Iterator<Rahakott> i = rahakotid.listIterator(); i.hasNext(); ) {
                        Rahakott rahakott = i.next();
                        if (Integer.toString(rahakott.getTunnusNumber()).equals(kood)) {
                            System.out.println("Olete kindel, et soovite rahakoti tunnusnumbriga " + kood + " kustutada? (Y/N)");
                            String yesOrNo = scan.nextLine().toUpperCase();
                            if (yesOrNo.equals("Y")) {
                                eemalda = true;
                            }
                        }
                    }

                    if (!eemalda)
                        System.out.println("Sellise tunnuskoodiga rahakotti ei leitud.");

                    if (eemalda) {
                        for (Rahakott rahakott : rahakotid) {
                            if (Integer.toString(rahakott.getTunnusNumber()).equals(kood)) {
                                rahakotid.remove(rahakott);
                                break;
                            }
                        }
                    }

                    FileWriter kirjutaja = new FileWriter(andmebaas);
                    FailiKirjutaja.kirjutaja(rahakotid, kirjutaja);

                }
            }
            else {
                System.out.println("Programm suletakse");
                java.lang.System.exit(0);
                break;
            }
        }
    }
}

