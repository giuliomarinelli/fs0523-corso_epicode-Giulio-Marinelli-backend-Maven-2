package week3.day3.esercizio_relazioni.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import week3.day3.esercizio_relazioni.entities.Persona;
import week3.day3.esercizio_relazioni.entities.Evento;
import week3.day3.esercizio_relazioni.entities.Partecipazione;

import java.util.UUID;

public class PartecipazioneDao {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void start() {
        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();
    }

    public static void close() {
        em.close();
        emf.close();
    }

    public static void save(Partecipazione p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.refresh(p);
    }

    public static Partecipazione getById(UUID id) {
        return em.find(Partecipazione.class, id);
    }

    public static Partecipazione getById(String id) {
        return getById(UUID.fromString(id));
    }

    public static void delete(UUID id) {
        Partecipazione p = getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(p);
        et.commit();
    }

    public static void delete(String id) {
        delete(UUID.fromString(id));
    }

}
