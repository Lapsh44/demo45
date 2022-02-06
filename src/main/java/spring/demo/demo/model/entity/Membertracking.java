package spring.demo.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "membertracking")
public class Membertracking {
//    @Id
//    @JsonProperty("id")
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;

    @Id
    @JsonProperty("character_id")
    @Column(name = "character_id")
    long characterId;

    @JsonProperty("location_id")
    @Column(name = "location_id")
    long locationId;

    @JsonProperty("logoff_date")
    @Column(name = "logoff_date")
    Date logoffDate;

    @JsonProperty("logon_date")
    @Column(name = "logon_date")
    Date logonDate;

    @JsonProperty("ship_type_id")
    @Column(name = "ship_type_id")
    int shipTypeId;

    @JsonProperty("start_date")
    @Column(name = "start_date")
    Date startDate;

}
