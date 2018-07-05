/* Grupa
* 1. Konrad Mojski
* 2. Tomasz Siemianowski
* 3. Przemysław Jezutek
* */
import ksiazki.Ksiazka;
import ksiazki.KsiazkaFantastyczna;
import ksiazki.KsiazkaHistoczyna;
import ksiazki.KsiazkaKlasyczna;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String csvFile = "src/biblioteka.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        Biblioteka biblioteka = new Biblioteka(10);

        try {

            br = new BufferedReader(new FileReader(csvFile));

            boolean pominPierwszaLinie = true;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (pominPierwszaLinie) {
                    pominPierwszaLinie = false;
                    continue;
                }

                String[] slowo = line.split(cvsSplitBy);
                LocalDate localDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                String formattedString = localDate.format(formatter);
                Ksiazka ksiazka = null;
                switch(Typ.valueOf(slowo[9].trim().toUpperCase())) {
                    case FANTASTYKA:
                        ksiazka = new KsiazkaFantastyczna(
                                slowo[0].trim(),
                                slowo[1].trim(),
                                slowo[2].trim(),
                                slowo[4].trim(),
                                Integer.parseInt(slowo[3].trim()),
                                Integer.parseInt(slowo[5].trim()),
                                Boolean.valueOf(slowo[6].trim()),
                                Boolean.valueOf(slowo[7].trim()),
                                slowo[8].trim().isEmpty() ? null : LocalDate.parse(slowo[8].trim(), formatter));
                        break;
                    case HISTORYCZNA:
                        ksiazka = new KsiazkaHistoczyna(
                                slowo[0].trim(),
                                slowo[1].trim(),
                                slowo[2].trim(),
                                slowo[4].trim(),
                                Integer.parseInt(slowo[3].trim()),
                                Integer.parseInt(slowo[5].trim()),
                                Boolean.valueOf(slowo[6].trim()),
                                slowo[8].trim().isEmpty() ? null : LocalDate.parse(slowo[8].trim(), formatter));
                        break;
                    case KLASYKA:
                        ksiazka = new KsiazkaKlasyczna(
                                slowo[0].trim(),
                                slowo[1].trim(),
                                slowo[2].trim(),
                                slowo[4].trim(),
                                Integer.parseInt(slowo[3].trim()),
                                Integer.parseInt(slowo[5].trim()),
                                Boolean.valueOf(slowo[6].trim()),
                                Boolean.valueOf(slowo[7].trim()),
                                slowo[8].trim().isEmpty() ? null : LocalDate.parse(slowo[8].trim(), formatter));
                        break;
                }

                biblioteka.dodajKsiazke(ksiazka, index);
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Interfejs.inicjuj(biblioteka);

    }


}