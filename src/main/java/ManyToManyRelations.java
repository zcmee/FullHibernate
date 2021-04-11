import entities.Attribute;
import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyRelations {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, 5l);
        Attribute attribute = em.find(Attribute.class, 1L);
        product.getAttributes().add(attribute);

        em.getTransaction().commit();
        em.close();
    }

}
