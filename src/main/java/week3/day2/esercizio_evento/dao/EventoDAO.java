//package week3.day2.esercizio_evento.dao;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import week3.day2.esercizio_evento.entities.Evento;
//
//import java.util.UUID;
//
//public class EventoDAO {
//
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//    private static EntityManager em = emf.createEntityManager();
//
//    public static void save(Evento e) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        em.persist(e);
//        et.commit();
//        em.refresh(e);
//    }
//
//    public static Evento getById(UUID id) {
//        return em.find(Evento.class, id);
//    }
//
//    public static Evento getById(String id) {
//        return getById(UUID.fromString(id));
//    }
//
//    public static void delete(UUID id) {
//        Evento e = getById(id);
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        em.remove(e);
//        et.commit();
//    }
//    public static void delete(String id) {
//        delete(UUID.fromString(id));
//    }
//
//}
