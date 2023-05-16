package org.sakute.telebot.persistance.dao;

import org.sakute.telebot.domain.entities.Admins;


public interface AdminDao {

  void createAdmin(Admins admin);

  void updateAdmin(Admins admin);

  void deleteAdmin(int adminId);

}
