package net.fryc.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KontoTest {

    @Test
    void testWplaty() {
        Konto testKonto = new Konto(List.of(new Osoba("Ktos", "Testowy", "000", "Twoj komputer", "010101")), "10");
        testKonto.setOtwarte(true);
        testKonto.setAktywne(true);

        testKonto.wplac(50F);
        Assertions.assertEquals(50F, testKonto.getSaldo());
        testKonto.wplac(-5F);
        Assertions.assertEquals(50F, testKonto.getSaldo());
    }

    @Test
    void testWyplaty() {
        Konto testKonto = new Konto(List.of(new Osoba("Ktos", "Testowy", "000", "Twoj komputer", "010101")), "10");
        testKonto.setOtwarte(true);
        testKonto.setAktywne(true);

        testKonto.wyplac(50F);
        Assertions.assertEquals(0F, testKonto.getSaldo());
        testKonto.wplac(50F);
        testKonto.wyplac(25F);
        Assertions.assertEquals(25F, testKonto.getSaldo());
        testKonto.wyplac(-25F);
        Assertions.assertEquals(25F, testKonto.getSaldo());
    }

    @Test
    void testZamkniecia() {
        Konto testKonto = new Konto(List.of(new Osoba("Ktos", "Testowy", "000", "Twoj komputer", "010101")), "10");

        Assertions.assertFalse(testKonto.isOtwarte());
        testKonto.wplac(50F);
        Assertions.assertEquals(0F, testKonto.getSaldo());
        testKonto.wyplac(1F);
        Assertions.assertEquals(0F, testKonto.getSaldo());

        testKonto.setOtwarte(true);
        Assertions.assertTrue(testKonto.isOtwarte());

    }

    @Test
    void testAktywacji() {
        Konto testKonto = new Konto(List.of(new Osoba("Ktos", "Testowy", "000", "Twoj komputer", "010101")), "10");
        testKonto.setOtwarte(true);

        Assertions.assertFalse(testKonto.isAktywne());
        testKonto.wplac(50F);
        Assertions.assertTrue(testKonto.isAktywne());
        testKonto.setAktywne(false);
        Assertions.assertFalse(testKonto.isAktywne());
        testKonto.wyplac(50F);
        Assertions.assertTrue(testKonto.isAktywne());

    }
}
