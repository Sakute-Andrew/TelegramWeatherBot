package org.sakute.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reminders")
public class Reminders{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reminder_id")
  private int reminderId;

  @Column(name = "premium_user_id")
  private int premiumUserId;

  @Column(name = "reminder_time")
  private Timestamp reminderTime;

  @Column(name = "reminder_type")
  private String reminderType;


}
