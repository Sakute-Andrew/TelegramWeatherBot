package org.sakute.telebot.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "search_history")
public class SearchHistory{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "history_id")
  private int historyId;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "weather_condition")
  private String weatherCondition;

  @Column(name = "date")
  private ZonedDateTime date;

  @Column(name = "temperature")
  private String temperature;

  @Column(name = "humidity")
  private String humidity;

  @Column(name = "windspeed")
  private String windspeed;

  @Column(name = "search_location")
  private String searchLocation;
}
