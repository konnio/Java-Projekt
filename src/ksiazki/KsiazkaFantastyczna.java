package ksiazki;

import java.time.LocalDate;

public class KsiazkaFantastyczna extends RezerwowalnaKsiazka{

    private static final int MAKSYMALNE_DLUGOSC_WYPOZYCZENIA = 30;
    private static int liczbaObiektow = 0;

    public KsiazkaFantastyczna(Ksiazka ksiazka) {
        super(ksiazka);
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: KsiazkaFantastyczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    public KsiazkaFantastyczna(String autor,
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
            System.out.println("Wywołano konstruktor: KsiazkaFantastyczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    @Override
    public void wyswietlKsiazke() {
        super.wyswietlKsiazke();
        System.out.println("Wypozyczenie na maksymalnie: " + MAKSYMALNE_DLUGOSC_WYPOZYCZENIA + " dni");
        System.out.println("");
    }

    public boolean czyZalegla(){
        return obliczDniZwloki() > MAKSYMALNE_DLUGOSC_WYPOZYCZENIA;
    }
}
