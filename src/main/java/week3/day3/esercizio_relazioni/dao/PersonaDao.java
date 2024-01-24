package week3.day3.esercizio_relazioni.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import week3.day3.esercizio_relazioni.entities.Persona;
import week3.day3.esercizio_relazioni.entities.Evento;

import java.util.UUID;

public class PersonaDao {

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

    public static void save(Persona p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.refresh(p);
    }

    public static Persona getById(UUID id) {
        return em.find(Persona.class, id);
    }

    public static Persona getById(String id) {
        return getById(UUID.fromString(id));
    }

    public static void delete(UUID id) {
        Persona p = getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(p);
        et.commit();
    }

    public static void delete(String id) {
        delete(UUID.fromString(id));
    }

}
