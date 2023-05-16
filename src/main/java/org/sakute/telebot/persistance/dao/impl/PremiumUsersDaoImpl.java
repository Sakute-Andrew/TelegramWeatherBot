package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakute.telebot.domain.entities.PremiumUsers;
import org.sakute.telebot.persistance.dao.PremiumUsersDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

import java.util.List;

public class PremiumUsersDaoImpl implements PremiumUsersDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();

  @Override
  public List<PremiumUsers> getAllPremiumUsers() {
    try (session) {
      String sqlQuery = "SELECT * FROM premium_users";
      List<PremiumUsers> query = session.createNativeQuery(sqlQuery, PremiumUsers.class).getResultList();
      return query;
    } catch (Exception e) {
      return null;
    } finally {
      session.close();
    }
  }



  @Override
  public void addPremiumUser(PremiumUsers premiumUser) {
    try (session) {
      String sqlQuery = "INSERT INTO premium_users (user_id, username, subscription_time, subscription_available_by) "
              + "VALUES (:userId, :username, CURRENT_TIMESTAMP, :availableBy)";
      Query query = session.createNativeQuery(sqlQuery);
      query.setParameter("userId", premiumUser.getUserId());
      query.setParameter("username", premiumUser.getUsername());
      query.setParameter("availableBy", premiumUser.getSubscriptionAvailableBy());
      query.executeUpdate();

    } catch (Exception e){

    } finally {
      session.close();
    }

  }

  @Override
  public void updatePremiumUser(PremiumUsers premiumUser) {
    try (session) {
      session.beginTransaction();
      String sqlQuery = "UPDATE premium_users SET subscription_available_by = :availableBy WHERE premium_user_id = :id";
      Query query = session.createNativeQuery(sqlQuery);
      query.setParameter("id", premiumUser.getUserId());
      query.setParameter("availableBy", premiumUser.getSubscriptionAvailableBy());
      query.executeUpdate();

    } catch (Exception e) {
      // Обробка винятків
    }
    finally {
      session.close();
    }

  }

  @Override
  public void deletePremiumUser(int premiumUserId) {
    try (session) {
      session.beginTransaction();
      String sqlQuery = "DELETE  FROM premium_users WHERE premium_user_id = :id";
      session.createNativeQuery(sqlQuery)
              .setParameter("id", premiumUserId)
              .executeUpdate();
      System.out.println("sdfsdhjf0sdohjf0sdhjf0sdjf0oswdf");
      session.getTransaction().commit();

    } catch (Exception e){

    } finally {
      session.close();
    }

  }
}
