package org.sakute.telebot.persistance.dao;

import java.util.List;
import org.sakute.telebot.domain.entities.SearchHistory;

public interface SearchHistoryDao {

  public abstract List<SearchHistory> getAllSearchHistory();
  public abstract void addSearchHistory(SearchHistory searchHistory,int id);
  public abstract boolean deleteSearchHistory(int id);
}
