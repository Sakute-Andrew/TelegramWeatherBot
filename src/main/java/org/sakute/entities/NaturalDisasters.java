package org.sakute.entities;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "natural_disasters")
public class NaturalDisasters {
    @Id
    @Column(name = "disaster_id")
    private int disasterId;

    @Column(name = "premiunm_user_id")
    private int premiumUserId;

    @Column(name = "disaster_type")
    private String disasterType;

    @Column(name = "disaster_time")
    private Timestamp disasterTime;

    @Column(name = "location")
    private String location;

    @Column(name = "disaster_description")
    private String disasterDescription;

}
