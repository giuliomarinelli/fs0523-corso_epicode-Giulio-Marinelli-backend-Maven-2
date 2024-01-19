package week2.day5;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio {
    public static Set<FonteLeggibile> biblioteca = new HashSet<>();

    public static void aggiungi(FonteLeggibile f) {
        biblioteca.add(f);
    }

    public static void rimuovi(String ISBN) {
        biblioteca.remove(ricercaPerISBN(ISBN));
    }

    public static FonteLeggibile ricercaPerISBN(String ISBN) {
        List<FonteLeggibile> contieneElementoTrovato = biblioteca.stream().filter(fl -> fl.getISBN().equals(ISBN))
                .collect(Collectors.toCollection(ArrayList<FonteLeggibile>::new));
        return contieneElementoTrovato.getFirst();
    }

    public static Set<FonteLeggibile> ricercaPerAnnoDiPubblicazione(int anno) {
        return biblioteca.stream().filter(fl -> fl.getAnnoDiPubblicazione() == anno)
                .collect(Collectors.toCollection(HashSet<FonteLeggibile>::new));
    }

    public static Set<FonteLeggibile> ricercaPerAutore(String autore) {
        return biblioteca.stream().filter(fl -> {
            if (fl instanceof Libro) {
                return ((Libro) fl).getAutore().equals(autore);
            }
            return false;
        }).collect(Collectors.toCollection(HashSet<FonteLeggibile>::new));
    }

    private static FonteLeggibile parsificaFonteLeggibile(String riga) {

        String[] props = riga.split("\\|");
        String ISBN = props[1];
        String titolo = props[2];
        int anno = Integer.parseInt(props[3]);
        int numeroDiPagine = Integer.parseInt(props[4]);
        String autore = "";
        String genere = "";
        Periodicita periodicita = Periodicita.SETTIMANALE; // Valore di default per evitare errori da parte di Java (variable may not have been initialized). Poi sarà sovrascritta
        if (props[0].equals("L")) {
            autore = props[5];
            genere = props[6];

        } else if (props[0].equals("R")) {
            periodicita = switch (props[5]) {
                case "SETTIMANALE" -> Periodicita.SETTIMANALE;
                case "MENSILE" -> Periodicita.MENSILE;
                case "SEMESTRALE" -> Periodicita.SEMESTRALE;
                default -> Periodicita.SETTIMANALE;
            };

        }


        return props[0].equals("L") ? new Libro(ISBN, titolo, anno, numeroDiPagine, autore, genere)
                : new Rivista(ISBN, titolo, anno, numeroDiPagine, periodicita);
    }

    private static String codificaFonteLeggibile(FonteLeggibile fl) {
        String identificatore = "";
        if (fl instanceof Libro) identificatore = "L";
        if (fl instanceof Rivista) identificatore = "R";
        String codifica = identificatore + "|" + fl.getISBN() + "|" + fl.getTitolo() + "|" +
                fl.getAnnoDiPubblicazione() + "|" + fl.getNumeroPagine();
        if (fl instanceof Libro) codifica += "|"
                + ((Libro) fl).getAutore() + "|" + ((Libro) fl).getGenere();
        if (fl instanceof Rivista) codifica += "|" + ((Rivista) fl).getPeriodicita();
        return codifica;
    }

    public static void salvaSuDisco() {
        File file = new File("archivio/archivio.txt");
        String content = biblioteca.stream().map(Archivio::codificaFonteLeggibile)
                .collect(Collectors.joining("\n"));
        try {
            FileUtils.writeStringToFile(file, content, Charset.defaultCharset(), false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void caricaDaDisco() {
        File file = new File("archivio/archivio.txt");
        try {
            biblioteca.clear();
            String content = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] righe = content.split("\n");
            Arrays.stream(righe).map(Archivio::parsificaFonteLeggibile).forEach(Archivio::aggiungi);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Aggiungo dei nuovi metodi per rendere più efficace l'interazione con la classe

    public static Set<FonteLeggibile> ricercaPerTitolo(String titolo) {
        return biblioteca.stream().filter(fl -> fl.getTitolo().equals(titolo))
                .collect(Collectors.toCollection(HashSet<FonteLeggibile>::new));
    }

    public static void visualizzaArchivio() {
        biblioteca.forEach(System.out::println);
    }

    public static void visualizzaTitoli() {
        System.out.println(biblioteca.stream()
                .map(FonteLeggibile::getTitolo).sorted(Comparator.naturalOrder())
                .collect(Collectors.toList()));
    }
}
