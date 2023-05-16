package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakute.telebot.domain.entities.Reminders;
import org.sakute.telebot.persistance.dao.RemindersDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

import java.util.List;

public class RemindersDaoImpl implements RemindersDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();

  @Override
  public List<Reminders> getAllReminders() {
    try (session) {
      String sqlQuery = "SELECT * FROM reminders";
      List<Reminders> query = session.createNativeQuery(sqlQuery, Reminders.class).getResultList();
      return query;
    } catch (Exception e){
      return null;

    } finally {
      session.close();
    }
  }

  @Override
  public void addReminder(Reminders reminder) {
    try (session) {
      String sqlQuery = "INSERT INTO reminders (premium_user_id, reminder_time, reminder_type)"
              + "VALUES (:id, :time, :type)";
      Query query = session.createNativeQuery(sqlQuery);
      query.setParameter("id", reminder.getPremiumUserId());
      query.setParameter("time", reminder.getReminderTime());
      query.setParameter("type", reminder.getReminderType());
      query.executeUpdate();
    } catch (Exception e){

    } finally {
      session.close();
    }

  }

  @Override
  public void updateReminder(Reminders reminder) {
    try (session) {
      String sqlQuery = "UPDATE reminders SET reminder_id = :newTime, reminder_type = :newType WHERE reminder_id = :id";
      session.createNativeQuery(sqlQuery)
              .setParameter("id", reminder.getReminderId())
              .setParameter("newType", reminder.getReminderType())
              .executeUpdate();
    } catch (Exception e){
    } finally {
      session.close();
    }

  }

  @Override
  public void deleteReminder(int reminderId) {
    try (session) {
      String sqlQuery = "DELETE FROM reminders WHERE reminder_id = :id";
      session.createNativeQuery(sqlQuery)
              .setParameter("id", reminderId)
              .executeUpdate();
    } catch (Exception e){
    } finally {
      session.close();
    }


  }
}
