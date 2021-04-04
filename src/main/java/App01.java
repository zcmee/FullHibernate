import entities.Product;
import entities.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.Instant;

public class App01 {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = new Product();
        product.setName("price 01");
        product.setDescription("Opis produktu");
        product.setCreated(Instant.now());
        product.setUpdated(Instant.now());
        product.setPrice(BigDecimal.TEN);
        product.setType(ProductType.REAL);
        em.persist(product);

        em.getTransaction().commit();
        System.out.println(product);

        em.close();
    }
}
