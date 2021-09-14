package com.vti.repository;

import com.vti.entity.Users;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UsersRepository {
    private HibernateUtils hibernateUtils;

    public UsersRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Users> query = session.createQuery("FROM Users");
            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
