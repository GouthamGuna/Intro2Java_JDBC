package in.dev.gmsk.controller;

import in.dev.gmsk.model.Address;
import in.dev.gmsk.model.User;
import in.dev.gmsk.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateApp {

    public static int mainMethod(User user, Address address) {

        Transaction transaction = null;
        Session session = null;
        int result = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            result = (Integer) session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (transaction != null) {
                    transaction.rollback();
                }
                if(session != null){
                    session.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }
}
