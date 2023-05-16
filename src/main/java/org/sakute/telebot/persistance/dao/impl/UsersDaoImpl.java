package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.sakute.telebot.domain.entities.Users;
import org.sakute.telebot.persistance.dao.UsersDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

import java.util.List;

public class UsersDaoImpl  implements UsersDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();

  @Override
  public List<Users> getAllUsers() {

    try (session) {
      String sqlQuery = "SELECT * FROM users";
      List<Users> users = session.createNativeQuery(sqlQuery, Users.class).getResultList();

      return users;
    } catch (Exception e){
      return null;
    } finally {
      session.close();
    }
  }

  @Override
  public void addUser(Users user) {
    try (session) {
      String sqlQuery = "INSERT INTO users (username, user_tag, location, subscription_type)" +
              " VALUES (:username, :userTag, :location, :subscriptionType)";
      session.createNativeQuery(sqlQuery)
              .setParameter("username", user.getUsername())
              .setParameter("userTag", user.getUserTag())
              .setParameter("location", user.getLocation())
              .setParameter("subscriptionType", user.getSubscriptionType())
              .executeUpdate();

    } catch (Exception e){

    } finally {
      session.close();
    }
  }

  @Override
  public void updateUser(Users user) {
    try (session) {
    String sqlQuery = "UPDATE users SET subscription_type = :type WHERE users_id = :id";
    session.createNativeQuery(sqlQuery)
              .setParameter("type", user.getSubscriptionType())
              .setParameter("id", user.getUsersId())
              .executeUpdate();

    } catch (Exception e){

    } finally {
      session.close();
    }

  }

  @Override
  public void deleteUser(int userId) {
    try (session) {
      String sqlQuery = "DELETE  FROM users WHERE users_id = :id";
      session.createNativeQuery(sqlQuery)
              .setParameter("id", userId)
              .executeUpdate();
      System.out.println("sdfsdhjf0sdohjf0sdhjf0sdjf0oswdf");
    } catch (Exception e){
    } finally {
      session.close();
    }
  }
}
