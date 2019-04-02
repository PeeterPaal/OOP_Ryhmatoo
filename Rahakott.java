package Ryhmatoo;

public class Rahakott implements Comparable<Rahakott>{
    private int tunnusNumber;
    private String omanikuNimi;
    private String valuutaNimi;
    private double valuutaKogus;
    private String kood;

    //getterid
    public int getTunnusNumber() {
        return tunnusNumber;
    }

    public double getValuutaKogus() {
        return valuutaKogus;
    }

    public String getOmanikuNimi() {
        return omanikuNimi;
    }

    public String getValuutaNimi() {
        return valuutaNimi;
    }

    public String getKood() {
        return kood;
    }

    //setterid
    public void setValuutaNimi(String valuutaNimi) {
        this.valuutaNimi = valuutaNimi;
    }

    public void setValuutaKogus(double valuutaKogus) {
        this.valuutaKogus = valuutaKogus;
    }

    public void setOmanikuNimi(String omanikuNimi) {
        this.omanikuNimi = omanikuNimi;
    }

    public void setTunnusNumber(int tunnusNumber) {
        this.tunnusNumber = tunnusNumber;
    }

    //konstruktor
    public Rahakott(int tunnusNumber, String omanikuNimi, String valuutaNimi, double valuutaKogus, String kood) {
        this.tunnusNumber = tunnusNumber;
        this.omanikuNimi = omanikuNimi;
        this.valuutaNimi = valuutaNimi;
        this.valuutaKogus = valuutaKogus;
        this.kood = kood;
    }

    public int compareTo(Rahakott võrreldav) {
        if (tunnusNumber < võrreldav.tunnusNumber) {
            return -1;
        }
        if (tunnusNumber > võrreldav.tunnusNumber) {
            return 1;
        }
        return 0;
    }

    //toString
    @Override
    public String toString() {
        return "Tunnusnumber: " + tunnusNumber + ", Omanik: " + omanikuNimi + ", Valuuta: " + valuutaNimi + ", Kogus: " + valuutaKogus + ", Rahakoti kood: " + kood;
    }
}
