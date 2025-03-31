package net.fryc.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KontoTest {

    @Test
    void testWplaty() {
        Konto testKonto = new Konto();

        testKonto.wplac(50F);
        Assertions.assertEquals(50F, testKonto.getSaldo());
        testKonto.wplac(-5F);
        Assertions.assertEquals(50F, testKonto.getSaldo());
    }

    @Test
    void testWyplaty() {
        Konto testKonto = new Konto();

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
        Konto testKonto = new Konto();
        testKonto.zamknijKonto();

        Assertions.assertFalse(testKonto.isOtwarte());
        testKonto.wplac(50F);
        Assertions.assertEquals(0F, testKonto.getSaldo());
        testKonto.wyplac(1F);
        Assertions.assertEquals(0F, testKonto.getSaldo());

        testKonto.otworzKonto();
        Assertions.assertTrue(testKonto.isOtwarte());

    }

    @Test
    void testAktywacji() {
        Konto testKonto = new Konto();
        testKonto.setStan(Stan.NIEAKTYWNE);

        Assertions.assertFalse(testKonto.isAktywne());
        testKonto.wplac(50F);
        Assertions.assertTrue(testKonto.isAktywne());
        testKonto.zamknijKonto();
        Assertions.assertFalse(testKonto.isAktywne());
        testKonto.otworzKonto();
        testKonto.wyplac(50F);
        Assertions.assertTrue(testKonto.isAktywne());

    }
}
