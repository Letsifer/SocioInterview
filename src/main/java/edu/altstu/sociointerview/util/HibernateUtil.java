package edu.altstu.sociointerview.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Евгений
 */
public class HibernateUtil {
    public static Session openSession() {
        return FACTORY.openSession();
    }
    
    private static SessionFactory FACTORY;
    private static ServiceRegistry REGISTRY;
    static {
        try {
            Configuration config = getConfiguration();
            REGISTRY = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            config.setSessionFactoryObserver(new SessionFactoryObserver() {
                @Override
                public void sessionFactoryCreated(SessionFactory factory) {
                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    StandardServiceRegistryBuilder.destroy(REGISTRY);
                }
            });
            FACTORY = config.buildSessionFactory(REGISTRY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        //TODO need to add all entites classes to configuration
//        configuration.addAnnotatedClass(Currency.class);
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/interview");
        configuration.setProperty("hibernate.connection.username", "test");
        configuration.setProperty("hibernate.connection.password", "test");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");           
        configuration.setProperty("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");           
        configuration.setProperty("hibernate.current_session_context_class", "thread"); 
        return configuration;
    }
}
