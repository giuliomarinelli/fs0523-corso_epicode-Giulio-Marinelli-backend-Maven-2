package week3.day3.esercizio_relazioni;


import week3.day3.esercizio_relazioni.entities.Evento;
import week3.day3.esercizio_relazioni.entities.TipoEvento;
import week3.day3.esercizio_relazioni.dao.EventoDao;
import week3.day3.esercizio_relazioni.dao.LocationDao;
import week3.day3.esercizio_relazioni.dao.PartecipazioneDao;
import week3.day3.esercizio_relazioni.dao.PersonaDao;
import week3.day3.esercizio_relazioni.entities.*;

import java.time.LocalDate;

public class UsaEvento {
    public static void main(String[] args) {
        PersonaDao.start();
        EventoDao.start();
        LocationDao.start();
        PartecipazioneDao.start();
        Evento e = new Evento("Superfesta", LocalDate.parse("2024-01-01"), "Evento bellissimo",
                TipoEvento.PUBBLICO, 200
                );
        Persona p = new Persona("Giovanni", "Storti", "abc@def.sfg", LocalDate.parse("2024-01-01"), Sesso.M);
        Partecipazione part1 = new Partecipazione(p, e, StatoPartecipazione.CONFERMATA);
        Location l = new Location("Piazza I Maggio", "Udine");
       EventoDao.save(e);
    }
}
