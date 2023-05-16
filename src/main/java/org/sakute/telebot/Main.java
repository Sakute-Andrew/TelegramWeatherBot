package org.sakute.telebot;

import org.sakute.telebot.persistance.dao.BlackListedUsersDao;
import org.sakute.telebot.persistance.dao.UsersDao;
import org.sakute.telebot.persistance.dao.impl.BlackListedUsersDaoImpl;
import org.sakute.telebot.persistance.dao.impl.UsersDaoImpl;

public class Main {

  public static void main(String[] args) {
      UsersDao dao = new UsersDaoImpl();
      System.out.println(dao.getAllUsers());





  }
}