package org.sakute.persistance.dao;

import java.util.List;
import org.sakute.entities.BlackListedUsers;
import org.sakute.entities.Users;

public interface BlackListedUsersDao {

  public abstract void addBlacklistedUser(Users user,String blacklistingReason);
  public abstract void getAllUsers(BlackListedUsers users);
  public abstract void updateBlacklistedUser(BlackListedUsers user);
  public abstract boolean deleteUserFromBlacklist(int blacklistedId);

}
