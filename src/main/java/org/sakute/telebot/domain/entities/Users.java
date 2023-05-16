package org.sakute.telebot.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "users_id")
  private int usersId;

  @Column(name = "username")
  private String username;

  @Column(name = "user_tag")
  private String userTag;

  @Column(name = "location")
  private String location;

  @Column(name = "subscription_type")
  private String subscriptionType;

}

