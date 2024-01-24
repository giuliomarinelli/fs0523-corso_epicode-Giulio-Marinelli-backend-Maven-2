package week3.day3.esercizio_relazioni.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import week3.day3.esercizio_relazioni.entities.Evento;

import java.util.UUID;

public class EventoDao {

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

    public static void save(Evento e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.refresh(e);
    }

    public static Evento getById(UUID id) {
        return em.find(Evento.class, id);
    }

    public static Evento getById(String id) {
        return getById(UUID.fromString(id));
    }

    public static void delete(UUID id) {
        Evento e = getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(e);
        et.commit();
    }

    public static void delete(String id) {
        delete(UUID.fromString(id));
    }

}
