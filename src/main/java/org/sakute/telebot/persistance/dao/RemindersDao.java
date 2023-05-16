package org.sakute.telebot.persistance.dao;

import java.util.List;
import org.sakute.telebot.domain.entities.Reminders;

public interface RemindersDao {

  public abstract List<Reminders> getAllReminders();
  public abstract void addReminder(Reminders reminder);
  public abstract void updateReminder(Reminders reminder);
  public abstract void deleteReminder(int reminderId);
}
