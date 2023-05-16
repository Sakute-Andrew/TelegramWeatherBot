package org.sakute.telebot.persistance.dao;

import java.util.List;
import org.sakute.telebot.domain.entities.PremiumUsers;

public interface PremiumUsersDao {

  public abstract List<PremiumUsers> getAllPremiumUsers();
  public abstract void addPremiumUser(PremiumUsers premiumUser);
  public abstract void updatePremiumUser(PremiumUsers premiumUser);
  public abstract void deletePremiumUser(int premiumUserId);
}
