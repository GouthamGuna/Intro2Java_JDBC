package in.dev.gmsk.controller;

import in.dev.gmsk.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserController {

    public static int saveUser(User user){

        int result = 0;

        try{

            StandardServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata =
                    new MetadataSources(serviceRegistry)
                    .getMetadataBuilder().build();

            SessionFactory sessionFactory =
                    metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            result = (Integer) session.save(user);

            transaction.commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
