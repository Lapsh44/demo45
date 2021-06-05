package spring.demo.demo.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "character")
public class Character {
    int alliance_id;
    int ancestry_id;
    String birthday;
    int bloodline_id;
    int corporation_id;
    String description;
    int faction_id;
    String gender;
    @Id
    String name;
    int race_id;
    float security_status;
    String title;


}
