package week3.day3.esercizio_relazioni.dao;

import week3.day3.esercizio_relazioni.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import week3.day3.esercizio_relazioni.entities.Persona;
import week3.day3.esercizio_relazioni.entities.Evento;

import java.util.UUID;

public class LocationDao {

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

    public static void save(Location l) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(l);
        et.commit();
        em.refresh(l);
    }

    public static Location getById(UUID id) {
        return em.find(Location.class, id);
    }

    public static Location getById(String id) {
        return getById(UUID.fromString(id));
    }

    public static void delete(UUID id) {
        Location l = getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(l);
        et.commit();
    }

    public static void delete(String id) {
        delete(UUID.fromString(id));
    }

}
