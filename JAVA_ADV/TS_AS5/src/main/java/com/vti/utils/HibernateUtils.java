package com.vti.utils;

import com.vti.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	/**
	 * This method is design pattern singleton to get object HibernateUtil.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 8, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 8, 2019
	 * @return Instance of ManagerHibernate
	 */
	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	/**
	 * Constructor for class HibernateUtils.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 25, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 25, 2020
	 */
	private HibernateUtils() {
		configure();
	}

	/**
	 * This method is created configuration object.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 20, 2020
	 */
	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Answer.class);
		configuration.addAnnotatedClass(CategoryQuestion.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(ExamQuestion.class);
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(GroupAccount.class);
		configuration.addAnnotatedClass(Manager.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Question.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(TypeQuestion.class);
	}

	/**
	 * This method is got SessionFactory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 20, 2020
	 */
	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	/**
	 * This method closes Factory session .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 8, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 8, 2019
	 */
	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	/**
	 * This method is opened session from SessionFactory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 25, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 25, 2020
	 */
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
