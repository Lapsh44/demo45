package spring.demo.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@JsonIgnoreProperties
@Data
@Entity
@Table (name = "characterdto")
public class CharacterDTO {
    @JsonProperty("alliance_id")
    @Column(name = "alliance_id")
    int allianceId;

    String birthday;

    @JsonProperty("bloodline_id")
    @Column(name = "bloodline_id")
    int bloodlineId;


    @JsonProperty("corporation_id")
    @Column(name = "corporation_id")
    int corporationId;

    String description;


    @JsonProperty("faction_id")
    @Column(name = "faction_id")
    int factionId;



    String gender;

    @Id
    String name;

    @JsonProperty("race_id")
    @Column(name = "race_id")
    int raceId;

    @JsonProperty("security_status")
    @Column(name = "security_status")
    float securityStatus;

    String title;


}
