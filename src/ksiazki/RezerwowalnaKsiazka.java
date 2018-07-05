package ksiazki;

import java.time.LocalDate;

public class RezerwowalnaKsiazka extends Ksiazka {

    private static final double oplataZadzienZwloki = 0.20;
    private static int liczbaObiektow = 0;

    protected RezerwowalnaKsiazka(Ksiazka ksiazka) {
        super(ksiazka);
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: RezerwowalnaKsiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    protected RezerwowalnaKsiazka(String autor,
                                  String tytul,
                                  String wydawca,
                                  String ISBN,
                                  int rok,
                                  int liczbaStron,
                                  boolean czyWypozyczona,
                                  boolean czyZarezerwowana,
                                  LocalDate dataWypozyczenia) {
        super(autor, tytul, wydawca, ISBN, rok, liczbaStron, czyWypozyczona, czyZarezerwowana, dataWypozyczenia);
        liczbaObiektow++;
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor: RezerwowalnaKsiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    @Override
    public void zarezerwuj() {
        if (czyZarezerwowana()) {
            System.out.println("Książka jest już zarezerwowana");
        } else {
            bezpiecznaRezerwacja();
        }
    }

    @Override
    public void odwojalRezerwacje() {
        if (czyZarezerwowana()) {
            bezpieczneOdwolanieRezerwacji();
        }
    }

    @Override
    public void wyswietlKsiazke() {
        super.wyswietlKsiazke();
        System.out.println("Rezerwacja: " + (czyZarezerwowana() ? "Tak" : "Nie"));
    }

    @Override
    public double obliczOplate() {
        if (czyWypozyczona() && czyZalegla()) {
            final long dniZwloki = obliczDniZwloki();
            double oplata = oplataZadzienZwloki * dniZwloki;
            System.out.println(this.wezTytul() + " - dni zwloki " + dniZwloki + "; oplata " + oplata + " zł");
            return oplata;
        }
        return 0;
    }
}
