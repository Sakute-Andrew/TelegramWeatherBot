package org.sakute.telebot.domain.entities;

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
@Table(name = "premium_users")
public class PremiumUsers{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "premium_user_id")
        private int premiumUserId;

        @Column(name = "user_id")
        private int userId;

        @Column(name = "username")
        private String username;

        @Column(name = "subscription_time")
        private Timestamp subscriptionTime;

        @Column(name = "subscription_available_by")
        private String subscriptionAvailableBy;




}
