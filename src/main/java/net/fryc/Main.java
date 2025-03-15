package net.fryc;

import net.fryc.lab1.Konto;
import net.fryc.lab1.Osoba;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Konto marek = new Konto(List.of(new Osoba("Marek", "Andrzej", "0", "Kolbuszowa", "36-100")), "1234");
        Konto wiesiek = new Konto(List.of(new Osoba("Karol", "Kowalski", "1", "Niwiska", "36-147")), "4321");
        Konto wspolne = new Konto(List.of(
                new Osoba("Patryk", "Nowak", "2", "Rzeszow", "nie znam"),
                new Osoba("Patrycja", "Nowak", "3", "Rzeszow", "nie znam")
        ), "12");

        marek.setOtwarte(true);
        wiesiek.setOtwarte(true);

        marek.setAktywne(true);

        System.out.println("Saldo Marka: " + marek.getSaldo());
        marek.wplac(50F);
        System.out.println("Saldo Marka: " + marek.getSaldo());
        marek.wyplac(80F);
        System.out.println("Saldo Marka: " + marek.getSaldo());
        marek.wyplac(25F);
        System.out.println("Saldo Marka: " + marek.getSaldo());

        System.out.println("Saldo Wieska: " + wiesiek.getSaldo());
        wiesiek.wplac(500F);
        System.out.println("Saldo Wieska: " + wiesiek.getSaldo());
        wiesiek.wplac(0F);
        System.out.println("Saldo Wieska: " + wiesiek.getSaldo());
        wiesiek.setOtwarte(false);

        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wplac(30F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wyplac(50F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wyplac(10F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
    }
}