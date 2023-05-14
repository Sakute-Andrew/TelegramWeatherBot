package org.sakute.persistance.dao;

import java.util.List;
import org.sakute.entities.SearchHistory;

public interface SearchHistoryDao {

  public abstract List<SearchHistory> getAllSearchHistory();
  public abstract void addSearchHistory(SearchHistory searchHistory);
  public abstract void updateSearchHistory(SearchHistory searchHistory);
  public abstract void deleteSearchHistory(int id);
}
