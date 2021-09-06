package com.vti.repository;

import org.hibernate.SessionFactory;

public class DepartmentRepository {
    private SessionFactory sessionFactory;

    public DepartmentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        // load config
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        // add entity
        configuration.addAnnotatedClass(TestingCategory.class);
        //
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
