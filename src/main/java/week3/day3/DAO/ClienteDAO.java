package week3.day3.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import week3.day3.entities.Cliente;

public class ClienteDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("magazzino");
        em = emf.createEntityManager();
    }

    public void inserisciCliente(Cliente c) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();
    }
}
