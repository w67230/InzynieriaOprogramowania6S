package net.fryc.lab1;

import java.time.LocalDateTime;

public class Konto {

    private float saldo = 0.0F;
    private LocalDateTime dataOstatniejTransakcji;
    private Stan stan;

    public Konto(){
        this.dataOstatniejTransakcji = LocalDateTime.now();
        this.stan = Stan.AKTYWNE;
    }

    public void wplac(float ilosc){
        this.getStan().wplac(this, ilosc);
    }

    public void wyplac(float ilosc){
        this.getStan().wyplac(this, ilosc);
    }

    public void zamknijKonto(){
        this.setStan(Stan.ZAMKNIETE);
    }

    public void otworzKonto(){
        this.setStan(Stan.NIEAKTYWNE);
    }

    public boolean tozsamoscZweryfikowana(){
        return true;
    }

    public void zaktualizujDateOstatniejTransakcji(){
        this.dataOstatniejTransakcji = LocalDateTime.now();
    }

    public boolean isAktywne() {
        return this.stan == Stan.AKTYWNE;
    }

    public boolean isOtwarte() {
        return this.stan != Stan.ZAMKNIETE;
    }

    public void addSaldo(float ilosc){
        this.saldo += ilosc;
    }

    public LocalDateTime getDataOstatniejTransakcji(){
        return this.dataOstatniejTransakcji;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public Stan getStan(){
        return this.stan;
    }

    public void setStan(Stan stan){
        this.stan = stan;
    }
}
