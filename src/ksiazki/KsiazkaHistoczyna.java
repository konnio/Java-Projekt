package ksiazki;

import java.time.LocalDate;

public class KsiazkaHistoczyna extends NierezerwowalnaKsiazka {
    private static int liczbaObiektow = 0;

    public KsiazkaHistoczyna(KsiazkaHistoczyna ksiazka) {
        super(ksiazka);
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: KsiazkaHistoryczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    public KsiazkaHistoczyna(String autor,
                             String tytul,
                             String wydawca,
                             String ISBN,
                             int rok,
                             int liczbaStron,
                             boolean czyWypozyczona,
                             LocalDate dataWypozyczenia) {
        super(autor, tytul, wydawca, ISBN, rok, liczbaStron, czyWypozyczona, dataWypozyczenia);
        liczbaObiektow++;
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor: KsiazkaHistoryczna; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }
    @Override
    public void wyswietlKsiazke() {
        super.wyswietlKsiazke();
        System.out.println("Wypozyczenie na maksymalnie: " + MAKSYMALNE_DLUGOSC_WYPOZYCZENIA + " dni");
        System.out.println("");
    }
}
