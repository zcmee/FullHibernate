import entities.Product;
import entities.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppRelations1 {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        List <Product> products = em.createQuery("SELECT product FROM Product product").getResultList();

//        System.out.println("DDDDDDDDD");
//        System.out.println(products.size());

        //pobranie reviews bez produktów, bo zrobi sie zapetlenia wywołan product
//        List <Review> reviews = em.createQuery("FROM Review review").getResultList();
//        reviews.forEach(review -> System.out.println(review));

        Product product = em.find(Product.class, 1L);
        em.remove(product);

        em.getTransaction().commit();
        em.close();
    }
}
