import ksiazki.Ksiazka;

import java.util.Scanner;

public class Interfejs {

    private static final Scanner scanner = new Scanner(System.in);

    public static void inicjuj(Biblioteka biblioteka) {
        narysujOpcje();
        while (true) {
            final String wprowadzonaOpcja = scanner.next();
            wybierzOpcjeGlowne(wprowadzonaOpcja, biblioteka);
        }
    }


    private static void narysujOpcje() {
        System.out.println("******************************************");
        System.out.println("System biblioteczny");
        System.out.println("Wprowadz numer opcji:");
        System.out.println("1: Lista ksiazek");
        System.out.println("2: Znajdz ksiazke");
        System.out.println("3: Wypozyczone ksiazki");
        System.out.println("4: Zarezerwowane ksiazki");
        System.out.println("5: Zalegle ksiazki");
        System.out.println("******************************************");
    }

    private static void wybierzOpcjeGlowne(String wprowadzonaOpcja, Biblioteka biblioteka) {
        switch (wprowadzonaOpcja) {
            case "1":
                biblioteka.listaKsiazek();
                break;
            case "2":
                przeprowadzWyszukiwanieKsiazki(biblioteka);
                break;
            case "3":
                System.out.println("Wypozyczone ksiazki:");
                biblioteka.listaWypozyczonychKsiazek();
                break;
            case "4":
                System.out.println("Zarezerwowane ksiazki:");
                biblioteka.listaZarezerwowanychKsiazek();
                break;
            case "5":
                final double zalegleOplaty = biblioteka.podsumujZalegleOplaty();
                System.out.println("Suma opłat wynosi: " + zalegleOplaty + " zł");
                break;
            default:
                System.out.println("Opcja nieznana. Wprowadz Opcje 1 - 5");
                break;
        }
        narysujOpcje();
    }

    private static void przeprowadzWyszukiwanieKsiazki(Biblioteka biblioteka) {
        System.out.println("Podaj tytuł szukanej ksiązki:");
        final String tytul = scanner.next();
        final Ksiazka ksiazka = biblioteka.znajdzKsiazkePoTytule(tytul);
        if (ksiazka != null) {
            ksiazka.wyswietlKsiazke();
            wyswietlOpcjeKontekstoweDlaKsiazki(ksiazka);
            oczekujIWykonajOpcjeKontekstowaDlaKsiazki(ksiazka);
        } else {
            System.out.println("Nie znaleziono  ksiązki o podanym tytule");
        }
        return;
    }

    private static void oczekujIWykonajOpcjeKontekstowaDlaKsiazki(Ksiazka ksiazka) {
        while(true){
            final String opcja = scanner.next();
            boolean powrotDoMenu = false;
            switch (opcja) {
                case "1":
                    ksiazka.wypozycz();
                    break;
                case "2":
                    ksiazka.zwroc();
                    break;
                case "3":
                    ksiazka.zarezerwuj();
                    break;
                case "4":
                    ksiazka.odwojalRezerwacje();
                    break;
                case "5":
                    powrotDoMenu = true;
                    break;
                default:
                    System.out.println("Opcja nieznana. Wprowadz Opcje 1 - X");
                    break;
            }
            ksiazka.wyswietlKsiazke();
            if(powrotDoMenu){
                break;
            }
            wyswietlOpcjeKontekstoweDlaKsiazki(ksiazka);
        }
    }

    private static void wyswietlOpcjeKontekstoweDlaKsiazki(Ksiazka ksiazka) {
        System.out.println("******************************************");
        System.out.println("Opcje dla powyzszej ksiazki:");
        System.out.println("1: Wypozycz");
        System.out.println("2: Zwrot");
        System.out.println("3: Zarezerwuj");
        System.out.println("4: Odwolaj rezerwacje");
        System.out.println("5: Powrót");
        System.out.println("******************************************");
    }

}
