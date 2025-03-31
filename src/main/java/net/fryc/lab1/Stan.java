package net.fryc.lab1;

public enum Stan {

    AKTYWNE {
        @Override
        public void wplac(Konto dys, float ilosc) {
            if(!Stan.czyMoznaWplacic(dys, ilosc)) return;

            dys.addSaldo(ilosc);
            dys.zaktualizujDateOstatniejTransakcji();
        }

        @Override
        public void wyplac(Konto dys, float ilosc) {
            if(!Stan.czyMoznaWyplacic(dys, ilosc)) return;

            dys.addSaldo(-ilosc);
            dys.zaktualizujDateOstatniejTransakcji();
        }
    },
    NIEAKTYWNE {
        @Override
        public void wplac(Konto dys, float ilosc) {
            if(!Stan.czyMoznaWplacic(dys, ilosc)) return;

            dys.addSaldo(ilosc);
            aktywuj(dys);
        }

        @Override
        public void wyplac(Konto dys, float ilosc) {
            if(!Stan.czyMoznaWyplacic(dys, ilosc)) return;

            dys.addSaldo(-ilosc);
            aktywuj(dys);
        }

        private static void aktywuj(Konto dys){
            dys.zaktualizujDateOstatniejTransakcji();
            dys.setStan(Stan.AKTYWNE);
            System.out.println("Konto zostalo ponownie aktywowane");
        }
    },
    ZAMKNIETE {
        @Override
        public void wplac(Konto dys, float ilosc) {
            System.out.println("Operacja niemożliwa - konto jest zamknięte");
        }

        @Override
        public void wyplac(Konto dys, float ilosc) {
            System.out.println("Operacja niemożliwa - konto jest zamknięte");
        }
    };

    public abstract void wplac(Konto dys, float ilosc);
    public abstract void wyplac(Konto dys, float ilosc);

    private static boolean czyIloscWiekszaNizZero(float ilosc){
        if(ilosc > 0){
            return true;
        }

        System.out.println("Kwota musi byc wieksza od 0!");
        return false;
    }

    private static boolean czyDozwolonaIloscWyplaty(Konto dys, float ilosc){
        if(dys.getSaldo() < ilosc){
            System.out.println("Brak srodkow na koncie!");
            return false;
        }

        return czyIloscWiekszaNizZero(ilosc);
    }

    private static boolean czyDozwolonaIloscWplaty(Konto dys, float ilosc){
        return czyIloscWiekszaNizZero(ilosc);
    }

    private static boolean czyMoznaWyplacic(Konto dys, float ilosc){
        return czyDozwolonaIloscWyplaty(dys, ilosc) && dys.tozsamoscZweryfikowana();
    }

    private static boolean czyMoznaWplacic(Konto dys, float ilosc){
        return czyDozwolonaIloscWplaty(dys, ilosc);
    }
}
