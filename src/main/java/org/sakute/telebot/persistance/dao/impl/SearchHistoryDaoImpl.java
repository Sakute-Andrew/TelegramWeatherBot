package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.sakute.telebot.domain.entities.SearchHistory;
import org.sakute.telebot.persistance.dao.SearchHistoryDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

import java.util.List;


public class SearchHistoryDaoImpl implements SearchHistoryDao {

  final Session session = HibernateUtil.getSessionFactory().openSession();

  @Override
  public List<SearchHistory> getAllSearchHistory() {
    try (session) {
      String sqlQuery = "SELECT * FROM search_history";
      List<SearchHistory> searchHistories = session.createNativeQuery(sqlQuery, SearchHistory.class).getResultList();
      return searchHistories;
    } catch (Exception e){
      return null;
    } finally {
      session.close();
    }
  }

  @Override
  public void addSearchHistory(SearchHistory searchHistory, int id) {
    try (session) {
      String sqlQuery = "INSERT INTO search_history (user_id, weather_condition, date, temperature, humidity, windspeed, search_location)" +
              " VALUES (:idHistory, :condition, :date, :temperature, :humidity, :windspeed)";
      session.createNativeQuery(sqlQuery)
              .setParameter("id", id)
              .setParameter("condition", searchHistory.getWeatherCondition())
              .setParameter("date", searchHistory.getDate())
              .setParameter("temperature", searchHistory.getTemperature())
              .setParameter("humidity", searchHistory.getHumidity())
              .setParameter("windspeed", searchHistory.getWindspeed())
             .executeUpdate();

    } catch (Exception e){

    } finally {
      session.close();
    }
  }

  @Override
  public boolean deleteSearchHistory(int id) {
    try (session) {
      String sqlQuery = "DELETE FROM search_history WHERE history_id = :idHistory";
      session.createNativeQuery(sqlQuery)
              .setParameter("idHistory", id)
              .executeUpdate();
        return true;
    } catch (Exception e){
        return false;
    } finally {

      session.close();
    }
  }
}
