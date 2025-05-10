package in.orcas.main;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import in.orcas.model.Project;

public class TestApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure(); // loads hibernate.cfg.xml

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // 1. Get CriteriaBuilder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // 2. Create CriteriaQuery for Project
            CriteriaQuery<Project> cQuery = builder.createQuery(Project.class);

            // 3. Define the root (FROM clause)
            Root<Project> root = cQuery.from(Project.class);

            // 4. Select full entity
            cQuery.select(root);

            // 5. Create named parameters for filtering
            ParameterExpression<Long> param1 = builder.parameter(Long.class, "minPid");
            ParameterExpression<Long> param2 = builder.parameter(Long.class, "maxPid");

            // 6. Apply filtering: pid >= minPid AND pid <= maxPid
            Predicate p1 = builder.ge(root.get("pid"), param1);
            Predicate p2 = builder.le(root.get("pid"), param2);
            Predicate combined = builder.and(p1, p2);
            cQuery.where(combined);

            // 7. Order by project name descending
            cQuery.orderBy(builder.desc(root.get("projName")));

            // 8. Create Query from CriteriaQuery
            Query<Project> query = session.createQuery(cQuery);

            // 9. Set named parameters
            query.setParameter("minPid", 102L);
            query.setParameter("maxPid", 105L);

            // 10. Execute and print results
            List<Project> list = query.getResultList();
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
