package com.vti.utils;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.*;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

//		EntityScanner.scanPackages("com.vti.entity")
//				.addTo(configuration);
		// add entity
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(GroupAccount.class);
		configuration.addAnnotatedClass(Manager.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Exam.class);
	}


	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}


	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}
}
