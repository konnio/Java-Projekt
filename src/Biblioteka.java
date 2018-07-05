import ksiazki.Ksiazka;

import java.util.Arrays;
import java.util.Objects;

public class Biblioteka {

    private Ksiazka[] spisKsiazek;

    Biblioteka(int liczba) {
        spisKsiazek = new Ksiazka[liczba];
    }

    void dodajKsiazke(Ksiazka ksiazka, int index) {
        spisKsiazek[index] = ksiazka;
    }

    public void listaKsiazek() {
        Arrays.asList(spisKsiazek).stream()
                .filter(Objects::nonNull)
                .forEach(Ksiazka::wyswietlKsiazke);
    }

    public Ksiazka znajdzKsiazkePoTytule(String tytuł) {
        return Arrays.asList(spisKsiazek).stream()
                .filter(ksiazka -> ksiazka.sprawdzTytul(tytuł))
                .findAny()
                .orElse(null);
    }

    public double podsumujZalegleOplaty() {
        return Arrays.asList(spisKsiazek).stream()
                .filter(Objects::nonNull)
                .filter(ksiazka -> ksiazka.czyWypozyczona())
                .filter(ksiazka -> ksiazka.czyZalegla())
                .mapToDouble(ksiazka -> ksiazka.obliczOplate())
                .sum();
    }

    public void listaWypozyczonychKsiazek() {
        Arrays.asList(spisKsiazek).stream()
                .filter(Objects::nonNull)
                .filter(Ksiazka::czyWypozyczona)
                .forEach(Ksiazka::wyswietlKsiazke);
    }

    public void listaZarezerwowanychKsiazek() {
        Arrays.asList(spisKsiazek).stream()
                .filter(Objects::nonNull)
                .filter(Ksiazka::czyZarezerwowana)
                .forEach(Ksiazka::wyswietlKsiazke);
    }
}