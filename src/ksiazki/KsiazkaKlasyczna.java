package ksiazki;

import java.time.LocalDate;

public class KsiazkaKlasyczna extends RezerwowalnaKsiazka{
    private static int liczbaObiektow = 0;

    public KsiazkaKlasyczna(KsiazkaKlasyczna ksiazka) {
        super(ksiazka);
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: KsiazkaKlasyczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    public KsiazkaKlasyczna(String autor,
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
            System.out.println("Wywołano konstruktor: KsiazkaKlasyczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }
    @Override
    public void wyswietlKsiazke() {
        super.wyswietlKsiazke();
        System.out.println("Wypozyczenie na maksymalnie: " + MAKSYMALNE_DLUGOSC_WYPOZYCZENIA + " dni");
        System.out.println("");
    }
}
