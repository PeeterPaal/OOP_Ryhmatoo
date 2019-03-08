package Ryhmatoo;

public class Rahakott {
    private long privaatneVõti;
    private long avalikVõti;

    //getterid
    public long getPrivaatneVõti() { return privaatneVõti; }
    public long getAvalikVõti() { return avalikVõti; }

    //setterid
    public void setPrivaatneVõti(long privaatneVõti) { this.privaatneVõti = privaatneVõti; }
    public void setAvalikVõti(long avalikVõti) { this.avalikVõti = avalikVõti; }

    //konstruktor
    public Rahakott(long privaatneVõti, long avalikVõti) {
        this.privaatneVõti = privaatneVõti;
        this.avalikVõti = avalikVõti;
    }
}
