package net.fryc.lab1;

public class Osoba {

    private final String imie;
    private final String pesel;

    private String nazwisko;
    private String adres;
    private String kodPocztowy;

    public Osoba(String imie, String nazwisko, String pesel, String adres, String kodPocztowy){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.kodPocztowy = kodPocztowy;
    }


    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return this.pesel;
    }

    public String getAdres() {
        return this.adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKodPocztowy() {
        return this.kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
