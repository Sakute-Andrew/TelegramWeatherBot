package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.sakute.telebot.domain.entities.NaturalDisasters;
import org.sakute.telebot.persistance.dao.NaturalDisastersDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

import java.util.List;

public class NaturalDisastersDaoImpl implements NaturalDisastersDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();

  public List<NaturalDisasters> getAllNaturalDisasters() {
    try (session) {
      String sqlQuery = "SELECT * FROM natural_disasters";
      List<NaturalDisasters> query = session.createNativeQuery(sqlQuery, NaturalDisasters.class).getResultList();
      return query;
    } catch (Exception e) {
      // Обробка помилок
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void addNaturalDisaster(NaturalDisasters naturalDisaster,int premiumUserId) {
    try (session) {
      session.beginTransaction();
      String sqlQuery = "INSERT INTO natural_disasters (premium_user_id, disaster_type, disaster_time, location, disaster_description)" +
              " VALUES (:userId, :disasterType, :disasterTime, :location, :disasterDescrip)";
      session.createNativeQuery(sqlQuery)
              .setParameter("userId", premiumUserId)
              .setParameter("disasterType", naturalDisaster.getDisasterType())
              .setParameter("disasterTime", naturalDisaster.getDisasterTime())
              .setParameter("location", naturalDisaster.getLocation())
              .setParameter("disasterDescrip", naturalDisaster.getDisasterDescription())
              .executeUpdate();
      session.getTransaction().commit();
    } catch (Exception e) {
      // Обробка помилок
      e.printStackTrace();
    }
  }


  @Override
  public void deleteNaturalDisaster(int disasterId) {
    try (session) {
      session.beginTransaction();
      String sqlQuery = "DELETE FROM natural_disasters WHERE disaster_id = :idDisaster";
      session.createNativeQuery(sqlQuery)
              .setParameter("idDisaster", disasterId)
              .executeUpdate();
      session.getTransaction().commit();
    } catch (Exception e) {
      // Обробка помилок
      e.printStackTrace();
    }
  }
}
