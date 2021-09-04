package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Employee> query = session.createQuery("FROM Employee");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
