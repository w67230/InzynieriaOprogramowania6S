package net.fryc;

import net.fryc.lab1.Konto;
import net.fryc.lab1.Stan;

public class Main {
    public static void main(String[] args) {
        Konto marek = new Konto();
        Konto wiesiek = new Konto();
        Konto wspolne = new Konto();

        marek.setStan(Stan.NIEAKTYWNE);

        wspolne.zamknijKonto();

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
        wiesiek.zamknijKonto();

        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wplac(30F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wyplac(50F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
        wspolne.wyplac(10F);
        System.out.println("Saldo Nowakow: " + wspolne.getSaldo());
    }
}