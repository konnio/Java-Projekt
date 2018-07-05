package ksiazki;

import java.time.LocalDate;

public class NierezerwowalnaKsiazka extends Ksiazka {

    private static final double oplataZadzienZwloki = 0.25;
    private static int liczbaObiektow = 0;

    NierezerwowalnaKsiazka(Ksiazka ksiazka) {
        super(ksiazka);
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: NierezerwowalnaKsiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    protected NierezerwowalnaKsiazka(String autor,
                                     String tytul,
                                     String wydawca,
                                     String ISBN,
                                     int rok,
                                     int liczbaStron,
                                     boolean czyWypozyczona,
                                     LocalDate dataWypozyczenia) {
        super(autor, tytul, wydawca, ISBN, rok, liczbaStron, czyWypozyczona, false, dataWypozyczenia);
        liczbaObiektow++;
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor: NierezerwowalnaKsiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    @Override
    public void zarezerwuj() {
        System.out.println("Opcja niedostepna");
    }

    @Override
    public void odwojalRezerwacje() {
        System.out.println("Opcja niedostepna");
    }

    @Override
    public double obliczOplate() {
        if (czyWypozyczona() && czyZalegla()) {
            final long dniZwloki = obliczDniZwloki();
            double oplata = oplataZadzienZwloki * dniZwloki;
            if (dniZwloki > 90) {
                oplata = oplata * 2;
            }
            System.out.println(this.wezTytul() + " - dni zwloki " + dniZwloki + "; oplata " + oplata + " zł");
            return oplata;
        }
        return 0;
    }


}
