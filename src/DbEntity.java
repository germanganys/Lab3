import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbEntity {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ResultUnit");
    public static EntityManager em = entityManagerFactory.createEntityManager();
}
