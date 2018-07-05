package ksiazki;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Ksiazka {
    protected static final int MAKSYMALNE_DLUGOSC_WYPOZYCZENIA = 60;
    protected static final boolean DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW = true;
    private static int liczbaObiektow = 0;

    private String autor;
    private String tytul;
    private String wydawca;
    private String ISBN;
    private int rok;
    private int liczbaStron;
    private boolean czyWypozyczona;
    private boolean czyZarezerwowana;
    private LocalDate dataWypozyczenia;


    protected Ksiazka(String autor,
                      String tytul,
                      String wydawca,
                      String ISBN,
                      int rok,
                      int liczbaStron,
                      boolean czyWypozyczona,
                      boolean czyZarezerwowana,
                      LocalDate dataWypozyczenia) {
        this.autor = autor;
        this.tytul = tytul;
        this.wydawca = wydawca;
        this.ISBN = ISBN;
        this.rok = rok;
        this.liczbaStron = liczbaStron;
        this.czyWypozyczona = czyWypozyczona;
        this.czyZarezerwowana = czyZarezerwowana;
        this.dataWypozyczenia = dataWypozyczenia;
        liczbaObiektow++;
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor: Ksiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    protected Ksiazka(Ksiazka ksiazka) {
        this.autor = ksiazka.autor;
        this.tytul = ksiazka.tytul;
        this.wydawca = ksiazka.wydawca;
        this.ISBN = ksiazka.ISBN;
        this.rok = ksiazka.rok;
        this.liczbaStron = ksiazka.liczbaStron;
        this.czyWypozyczona = ksiazka.czyWypozyczona;
        this.czyZarezerwowana = ksiazka.czyZarezerwowana;
        this.dataWypozyczenia = ksiazka.dataWypozyczenia;
        if(DRUKOWANIE_WYWOLANIA_KONSTRUKTOROW){
            System.out.println("Wywołano konstruktor kopiujacy: Ksiazka; liczba obiektow:" + zwrocLiczbeObiektow());
        }
    }

    public boolean czyWypozyczona() {
        return czyWypozyczona;
    }

    public boolean czyZalegla(){
        return obliczDniZwloki() > MAKSYMALNE_DLUGOSC_WYPOZYCZENIA;
    }

    public void wypozycz() {
        if (czyWypozyczona) {
            System.out.println("Ta książka jest już wypozyczona");
        } else {
            czyWypozyczona = true;
            dataWypozyczenia = LocalDate.now();
        }
    }

    public void oddaj() {
        czyWypozyczona = false;
    }

    public abstract void zarezerwuj();

    protected void bezpiecznaRezerwacja() {
        czyZarezerwowana = true;
    }

    public abstract void odwojalRezerwacje();

    protected void bezpieczneOdwolanieRezerwacji() {
        czyZarezerwowana = false;
    }

    public String wezTytul() {
        return this.tytul;
    }

    public boolean czyZarezerwowana() {
        return this.czyZarezerwowana;
    }

    public LocalDate wezDateWypozyczenia() {
        return dataWypozyczenia;
    }

    public void wyswietlKsiazke() {
        System.out.println("Autor: " + autor);
        System.out.println("Tytuł: " + tytul);
        System.out.println("Wydawca: " + wydawca);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Rok: " + rok);
        System.out.println("Liczba stron: " + liczbaStron);
        System.out.println("Dostepnosc: " + (czyWypozyczona() ? "Wypozyczona (" + wezDateWypozyczenia() + ")" : "Dostępna"));
    }

    public boolean sprawdzTytul(String tytul) {
        return this.tytul.equals(tytul);
    }

    public void zwroc() {
        if (czyWypozyczona) {
            czyWypozyczona = false;
            dataWypozyczenia = null;
        } else {
            System.out.println("Książak nie jest wypożyczona");
        }
    }

    public abstract double obliczOplate();

    protected long obliczDniZwloki() {
        return DAYS.between(wezDateWypozyczenia(), LocalDate.now());
    }

    public static int zwrocLiczbeObiektow(){
        return liczbaObiektow;
    }
}
