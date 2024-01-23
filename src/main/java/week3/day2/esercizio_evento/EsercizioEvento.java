package week3.day2.esercizio_evento;//package week3.day2.esercizio_evento;

import week3.day2.esercizio_evento.dao.EventoDAO;
import week3.day2.esercizio_evento.entities.Evento;
import week3.day2.esercizio_evento.entities.TipoEvento;

import java.time.LocalDate;

public class EsercizioEvento {
    public static void main(String[] args) {
        Evento e1 = new Evento("Motoraduno", LocalDate.of(2024, 1, 1), "Tante moto tutte insieme",
                TipoEvento.PUBBLICO, 200);
//        EventoDAO.save(e1);

        Evento e2 = new Evento("Festino", LocalDate.of(2024, 1, 1), "Tanto casino",
                TipoEvento.PRIVATO, 20);
//        EventoDAO.save(e2);
        Evento e3 = new Evento("Apertura farmacia", LocalDate.of(2025, 1, 1), "Soci",
                TipoEvento.PRIVATO, 3);
//        EventoDAO.save(e3);
//        EventoDAO.save(new Evento("Super evento yeeehhh", LocalDate.parse("2024-01-23"),
//                "Tanta festa", TipoEvento.PUBBLICO, 1000));
//        EventoDAO.save(new Evento("Evento 5", LocalDate.parse("2022-01-01"),
//                "Tanti dolci", TipoEvento.PRIVATO, 20));
//        EventoDAO.save(new Evento("Evento 6", LocalDate.parse("2022-11-01"),
//                "Tanti baci", TipoEvento.PRIVATO, 2));
//        EventoDAO.save(new Evento("Il grande evento dell'anno", LocalDate.parse("2022-11-01"),
//                "Fiesta aleeeeeehhh", TipoEvento.PRIVATO, 18));
//        EventoDAO.save(new Evento("Anniversario", LocalDate.parse("2024-11-01"),
//                "Coccole", TipoEvento.PRIVATO, 2));
        System.out.println("ricerca per id = 511639e1-18f3-4beb-9551-66a0c7d898d0: " + EventoDAO.getById("511639e1-18f3-4beb-9551-66a0c7d898d0"));
        System.out.println("ricerca per id = dbb64b2d-c7a9-4b56-a996-e6c8ba1fa49f: " + EventoDAO.getById("dbb64b2d-c7a9-4b56-a996-e6c8ba1fa49f"));
        System.out.println("ricerca per id = a067faa4-d136-4002-b5bf-5440e91f26f9: " + EventoDAO.getById("a067faa4-d136-4002-b5bf-5440e91f26f9"));
        EventoDAO.delete("034093ca-ad0a-40df-84ff-ff57c4191d88");

    }

}
