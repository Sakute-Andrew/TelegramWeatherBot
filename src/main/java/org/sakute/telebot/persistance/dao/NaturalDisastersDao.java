package org.sakute.telebot.persistance.dao;

import java.util.List;
import org.sakute.telebot.domain.entities.NaturalDisasters;

public interface NaturalDisastersDao {

  public abstract List<NaturalDisasters> getAllNaturalDisasters();
  public abstract void addNaturalDisaster(NaturalDisasters naturalDisaster, int user);
  public abstract void deleteNaturalDisaster(int disasterId);

}
