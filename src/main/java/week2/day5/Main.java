package week2.day5;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Archivio.aggiungi(new Libro("Il nome della rosa",
                1970, 600, "Umberto Eco", "Giallo storico"));

        Archivio.aggiungi(new Rivista("Gente", 1980, 50, Periodicita.SETTIMANALE));


        Archivio.aggiungi(new Libro("Il pendolo di Foucault", 1980,
                600, "Umberto Eco", "Filosofico"));

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
        Archivio.rimuovi("969-28-06242-57-0");
        Archivio.rimuovi("104-31-81893-35-8");
        Archivio.visualizzaArchivio();
        Archivio.visualizzaTitoli();




    }
}