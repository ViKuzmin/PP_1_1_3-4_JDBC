package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.setProperty("connection.username", "root")
                        .setProperty("connection.password", "F4aef2aB")
                        .setProperty("connection.url", "jdbc:mysql://localhost:3306/user")
                        .setProperty("connection.driver_class", "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .setProperty("show_sql", "true");


                /*Configuration configuration = new Configuration()
                        .addAnnotatedClass(User.class)
                        .setProperty("connection.username", "root")
                        .setProperty("connection.password", "F4aef2aB")
                        .setProperty("connection.url", "jdbc:mysql://localhost:3306/user")
                        .setProperty("connection.driver_class", "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .setProperty("show_sql", "true");*/


                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}