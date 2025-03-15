package net.fryc.lab1;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Konto {

    private final HashSet<Osoba> wlasciciele = new HashSet<>();

    private boolean aktywne = false;
    private boolean otwarte = false;

    private float saldo = 0.0F;
    private String pin;
    private LocalDateTime dataOstatniejTransakcji;

    public Konto(Collection<Osoba> wlasciciele, String pin){
        this.wlasciciele.addAll(wlasciciele);
        this.dataOstatniejTransakcji = LocalDateTime.now();
        this.pin = pin;
    }

    public void wplac(float ilosc){
        if(this.sprawdzCzyKontoOtwarte()){
            if(czyDozwolonaIlosc(ilosc)){
                this.saldo += ilosc;
                this.zaktualizujDateOstatniejTransakcji();
                this.sprobujReaktywowac();
            }
        }
    }

    public void wyplac(float ilosc){
        if(this.sprawdzCzyKontoOtwarte()){
            if(czyDozwolonaIlosc(ilosc)){
                if(ilosc > this.saldo){
                    System.out.println("Brak wystarczajacych srodkow na koncie!");
                }
                else if(this.zweryfikujTozsamosc()){
                    //if(BankHelper.wydajPieniadze()){
                    this.saldo -= ilosc;
                    this.zaktualizujDateOstatniejTransakcji();
                    this.sprobujReaktywowac();
                    //}
                    //else {
                    //    System.out.println("Wystapil blad podczas proby wyplaty srodkow. Pieniadze nie zostaly pobrane z konta.");
                    //}
                }
            }
        }
    }

    public boolean zweryfikujTozsamosc(){
        /*
        Scanner scanner = new Scanner(System.in);
        String pin;
        int proby = 3;
        while(--proby > 0){
            System.out.println("Podaj PIN");
            pin = scanner.nextLine();
            if(pin.equals(this.pin)){
                return true;
            }
            else {
                System.out.println("Podany PIN jest niepoprawny");
            }
        }

        System.out.println("Przekroczono liczbe dostepnych prob. Weryfikacja nieudana.");
        return false;
         */
        return true;
    }

    private void sprobujReaktywowac(){
        if(!this.isAktywne()){
            this.setAktywne(true);
            System.out.println("Konto zostalo ponownie aktywowane");
            //BankHelper.wyslijMailaReaktywacyjnego(this.getWlasciciele());
        }
    }

    private boolean sprawdzCzyKontoOtwarte(){
        if(this.isOtwarte()){
            return true;
        }

        System.out.println("Nie mozna wykonac operacji - konto jest zamkniete");
        return false;
    }

    private void zaktualizujDateOstatniejTransakcji(){
        this.dataOstatniejTransakcji = LocalDateTime.now();
    }

    public Set<Osoba> getWlasciciele(){
        return this.wlasciciele;
    }


    public boolean isAktywne() {
        return this.aktywne;
    }

    public void setAktywne(boolean aktywne) {
        this.aktywne = aktywne;
    }

    public boolean isOtwarte() {
        return otwarte;
    }

    public void setOtwarte(boolean otwarte) {
        this.otwarte = otwarte;
    }

    public LocalDateTime getDataOstatniejTransakcji(){
        return this.dataOstatniejTransakcji;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void setPin(String pin){
        this.pin = pin;
    }

    private static boolean czyDozwolonaIlosc(float ilosc){
        if(ilosc > 0){
            return true;
        }

        System.out.println("Kwota musi byc wieksza od 0!");
        return false;
    }
}
