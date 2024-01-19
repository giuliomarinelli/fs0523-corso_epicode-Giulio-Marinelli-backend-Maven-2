package week2.day5;

import org.w3c.dom.ls.LSOutput;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
//        Archivio.aggiungi(new Libro("Il nome della rosa",
//                1970, 600, "Umberto Eco", "Giallo storico"));
//
//        Archivio.aggiungi(new Rivista("Gente", 1980, 50, Periodicita.SETTIMANALE));
//
//
//        Archivio.aggiungi(new Libro("Il pendolo di Foucault", 1980,
//                600, "Umberto Eco", "Filosofico"));
//
//        System.out.println(Archivio.ricercaPerAutore("Umberto Eco"));
//        System.out.println();
//        System.out.println(Archivio.ricercaPerAnnoDiPubblicazione(1980));
//        System.out.println();
//        System.out.println(Archivio.ricercaPerTitolo("Il nome della rosa"));
//        System.out.println();
//        Archivio.visualizzaArchivio();
//        Archivio.aggiungi(new Libro("Profumo", 2000, 400,
//                "Patrick Suskind", "Thriller"));
//        Archivio.aggiungi(new Rivista("Moto2", 2022, 30, Periodicita.SEMESTRALE));
//        Archivio.aggiungi(new Libro("Anfitrione", -400,
//                100, "Plauto", "Commedia"));
//        Archivio.aggiungi(new Libro("Ti prendo e ti porto via", 2005,
//                350, "Niccolò Ammaniti", "Giallo"));
//        Archivio.aggiungi(new Rivista("Quattroruote", 2022, 30,
//                Periodicita.MENSILE));
//        Archivio.salvaSuDisco();
        Archivio.caricaDaDisco();
        System.out.println("\nLA MIA BIBLIOTECA\n");
        Archivio.visualizzaArchivio();
        System.out.println();
        System.out.println(Archivio.ricercaPerISBN("213-44-58964-65-3"));
        System.out.println();
        Archivio.rimuovi("213-44-58964-65-3"); // Rimuovo Profumo
        Archivio.rimuovi("377-26-49591-67-5"); // Rimuovo Quattroruote
        System.out.println("Rimossi Profumo (libro) e Quattroruote (rivista)");
        System.out.println();
        Archivio.visualizzaArchivio();
        System.out.println();
        System.out.println("I TITOLI DEI MIEI LIBRI");
        System.out.println();
        Archivio.visualizzaTitoli();
        System.out.println();
        // catturo l'eccezione che viene lanciata quando cerco per ISBN un elemento che non esiste --> Questo è l'unico metodo di ricerca che genera un'eccezione in assenza di match. Gli altri restituiscono collection vuote.
        try {
            Archivio.ricercaPerISBN("213-44-58964-65-3");
        } catch (NoSuchElementException e) {
            System.out.println("Elemento inesistente");
        }
        System.out.println();
        System.out.println("Ricerca per autore: " + Archivio.ricercaPerAutore("Umberto Eco"));
        System.out.println();
        System.out.println("Ricerca per anno: " + Archivio.ricercaPerAnnoDiPubblicazione(2022));
        System.out.println();
        System.out.println("Cerco La locandiera per titolo (che non c'è): " + Archivio.ricercaPerTitolo("La locandiera"));




    }
}