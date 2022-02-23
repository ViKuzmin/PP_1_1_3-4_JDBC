package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    private SessionFactory sessionFactory;
    //User user = new User();

    /*{
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }*/

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        /*Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();*/
    }

    @Override
    public void removeUserById(long id) {

/*        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);

        Transaction transaction = session.getTransaction();
        session.delete(User.class, id);
        transaction.commit();
        session.close();*/

        // return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> list = (List<User>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("FROM User").list();
        return list;
    }

    @Override
    public void cleanUsersTable() {

    }
}
