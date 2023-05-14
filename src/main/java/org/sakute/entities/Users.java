package org.sakute.entities;

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

  @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
  private BlackListedUsers blackListedUsers;
  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  private SearchHistory searchHistory;
  @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
  private PremiumUsers premiumUsers;


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

