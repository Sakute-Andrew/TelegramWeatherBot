package org.sakute.telebot.persistance.dao;

import org.sakute.telebot.domain.entities.BlackListedUsers;
import org.sakute.telebot.domain.entities.Users;

public interface BlackListedUsersDao {

  public abstract void addBlacklistedUser(Users user, String blacklistingReason);
  public abstract void getAllUsers(BlackListedUsers users);
  public abstract void updateBlacklistedUser(BlackListedUsers user);
  public abstract boolean deleteUserFromBlacklist(int blacklistedId);

}
