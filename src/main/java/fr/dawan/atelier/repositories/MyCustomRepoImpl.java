package fr.dawan.atelier.repositories;

import fr.dawan.atelier.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class MyCustomRepoImpl implements MyCustomRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAllByMultipleParam(String desc, double price) {
        List<Product> lp = null;
        String req = "FROM Product p";
        if(desc!=null)
            req+="WHERE p.description LIKE :desc";
        // TODO : faire un if sur le price

        Query q = em.createQuery(req);
        if(desc != null)
            q.setParameter("desc", "%"+desc);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            lp = q.getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return lp;
    }
}
