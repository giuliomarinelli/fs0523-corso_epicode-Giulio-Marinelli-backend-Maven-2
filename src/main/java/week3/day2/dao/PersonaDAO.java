package week3.day2.dao;

import week3.day2.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        // creo l'emf e l'em
        emf = Persistence.createEntityManagerFactory("epicodeJpa");
        em = emf.createEntityManager();
    }

    public void inserisciPersona(Persona p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p); // Genera un'entità di tipo persona nell'entity context
        et.commit(); // Termino la transazione e se tutto va bene p dall'entity context sarà salvata nel DB
        em.refresh(p);

    }

    public Persona getById(int id) {
        // Per le SELECT non servono transazioni, uso direttamente metodi dell'enitity manager
        return em.find(Persona.class, id);

    }

    public void cancellaPersona(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Persona p = getById(id);
        em.remove(p);
        et.commit();
    }

}
