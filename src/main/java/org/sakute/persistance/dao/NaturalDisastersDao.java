package org.sakute.persistance.dao;

import java.util.List;
import org.sakute.entities.NaturalDisasters;

public interface NaturalDisastersDao {

  public abstract List<NaturalDisasters> getAllNaturalDisasters();
  public abstract void addNaturalDisaster(NaturalDisasters naturalDisaster);
  public abstract void updateNaturalDisaster(NaturalDisasters naturalDisaster);
  public abstract void deleteNaturalDisaster(int disasterId);

}
