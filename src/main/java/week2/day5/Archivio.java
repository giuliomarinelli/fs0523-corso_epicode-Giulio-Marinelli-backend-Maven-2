package week2.day5;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;


public class Archivio {

    private static final Logger logger
            = LoggerFactory.getLogger("Archivio");
    public static Set<FonteLeggibile> biblioteca = new HashSet<>();

    public static void aggiungi(FonteLeggibile f) {
        biblioteca.add(f);
        logger.info("Aggiunto nuovo libro o rivista ISBN " + f.getISBN());
    }

    public static void rimuovi(String ISBN) {
        biblioteca.remove(ricercaPerISBN(ISBN));
        logger.info("Rimosso libro o rivista ISBN " + ISBN);
    }

    public static FonteLeggibile ricercaPerISBN(String ISBN) {
        List<FonteLeggibile> contieneElementoTrovato = biblioteca.stream().filter(fl -> fl.getISBN().equals(ISBN))
                .collect(Collectors.toCollection(ArrayList<FonteLeggibile>::new));
        logger.info("Cercato libro o rivista per ISBN: " + ISBN);
        return contieneElementoTrovato.getFirst();
    }

    public static Set<FonteLeggibile> ricercaPerAnnoDiPubblicazione(int anno) {
        logger.info("Effettuata ricerca per anno di pubblicazione: " + anno);
        return biblioteca.stream().filter(fl -> fl.getAnnoDiPubblicazione() == anno)
                .collect(Collectors.toCollection(HashSet<FonteLeggibile>::new));
    }

    public static Set<FonteLeggibile> ricercaPerAutore(String autore) {
        logger.info("Effettuata ricerca per autore: " + autore);
        return biblioteca.stream().filter(fl -> {
            if (fl instanceof Libro) {
                return ((Libro) fl).getAutore().equals(autore);
            }
            return false;
        }).collect(Collectors.toCollection(HashSet<FonteLeggibile>::new));
    }

    private static FonteLeggibile parsificaFonteLeggibile(String riga)  {

        String[] props = riga.split("\\|");
        try {
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
            logger.info("Generata una nuova istanza di Libro o Rivista da una riga del file");
            return props[0].equals("L") ? new Libro(ISBN, titolo, anno, numeroDiPagine, autore, genere)
                    : new Rivista(ISBN, titolo, anno, numeroDiPagine, periodicita);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Errore di parsificazione dei dati presi da file, resituito libro \"vuoto\"");
            return new Libro("", 0, 0, "", "");
        }
    }

    private static String codificaFonteLeggibile(FonteLeggibile fl) {
        try {
            String identificatore = "";
            if (fl instanceof Libro) identificatore = "L";
            if (fl instanceof Rivista) identificatore = "R";
            String codifica = identificatore + "|" + fl.getISBN() + "|" + fl.getTitolo() + "|" +
                    fl.getAnnoDiPubblicazione() + "|" + fl.getNumeroPagine();
            if (fl instanceof Libro) codifica += "|"
                    + ((Libro) fl).getAutore() + "|" + ((Libro) fl).getGenere();
            if (fl instanceof Rivista) codifica += "|" + ((Rivista) fl).getPeriodicita();
            logger.info("Codificato oggetto per salvataggio su file");
            return codifica;
        } catch (NullPointerException e) {
            System.out.println("Si è verificato un errore. Non posso codificare i dati per" +
                    " salvarli perché si è verificata una perdita di dati");
            logger.error("Errore nella codifica degli oggetti per salvarli su file");
            return "";
        }
    }

    public static void salvaSuDisco() {
        File file = new File("archivio/archivio.txt");
        String content = biblioteca.stream().map(Archivio::codificaFonteLeggibile)
                .collect(Collectors.joining("\n"));
        try {
            FileUtils.writeStringToFile(file, content, Charset.defaultCharset(), false);
            logger.info("Nuovo file archivio/archivio.txt");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore, impossibile salvare su disco => " + e.getMessage());
            logger.error("Errore di File System in scrittura");
        }
    }

    public static void caricaDaDisco() {
        File file = new File("archivio/archivio.txt");
        try {
            biblioteca.clear();
            String content = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] righe = content.split("\n");
            Arrays.stream(righe).map(Archivio::parsificaFonteLeggibile)
                    .forEach(Archivio::aggiungi);
            logger.info("Effettuata lettura da archivio/archivio.txt");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore nel caricamento da disco. Impossibile caricare => "
                    + e.getMessage());
            logger.info("Errore di File System in lettura");
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
