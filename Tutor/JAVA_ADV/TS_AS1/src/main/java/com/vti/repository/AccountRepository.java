package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {
    public List<Account> getAllAccounts() {
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            Query<Account> query = session.createQuery("FROM Account");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Account getById(int accountId) {
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            Account ent = session.get(Account.class, accountId);
            return ent;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAccount(Account Account) {
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            session.save(Account);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
