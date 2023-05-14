package org.sakute.persistance.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.sakute.entities.BlackListedUsers;
import org.sakute.entities.Users;
import org.sakute.persistance.dao.BlackListedUsersDao;
import org.sakute.persistance.utility.HibernateUtil;

public class BlackListedUsersDaoImpl implements BlackListedUsersDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();
  @Override
  public void addBlacklistedUser(Users user, String blacklistingReason) {
    try (session) {
      session.beginTransaction();
      String sqlQuery = "INSERT INTO blacklisted_users (user_id, username, blacklisting_time, blacklisting_reason) "
          + "VALUES (:userId, :username, CURRENT_TIMESTAMP, :reason)";
      Query query = session.createSQLQuery(sqlQuery);
      query.setParameter("userId", user.getUsersId());
      query.setParameter("username", user.getUsername());
      query.setParameter("reason", blacklistingReason);
      query.executeUpdate();
      session.getTransaction().commit();
    } catch (Exception e) {
      // Обробка винятків
    }

  }

  @Override
  public void getAllUsers(BlackListedUsers users) {
    try (session) {



    } catch (Exception e) {
      // Обробка помилок
      e.printStackTrace();

    }

  }

  @Override
  public void updateBlacklistedUser(BlackListedUsers user) {
    session.beginTransaction();
    String sqlQuery = "UPDATE blacklisted_users SET blacklisting_reason = :reason WHERE blacklisted_id = :id";
    Query query = session.createNativeQuery(sqlQuery);
    query.setParameter("reason", user.getBlacklistingReason());
    query.setParameter("id", user.getBlacklistedId());
    query.executeUpdate();
    session.getTransaction().commit();
  }

  @Override
  public boolean deleteUserFromBlacklist(int blacklistedId) {
      session.beginTransaction();
      String sqlQuery = "DELETE FROM blacklisted_users WHERE blacklisted_id = :id";
      Query query = session.createNativeQuery(sqlQuery);
      query.setParameter("id", blacklistedId);
      query.executeUpdate();
      session.getTransaction().commit();
    return true;
  }
}
