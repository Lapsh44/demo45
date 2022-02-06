package spring.demo.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table (name = "characters")
public class CharactersPOJO {
    @JsonProperty("id")
    @Column(name = "id")
    long id;
    @Id
    @JsonProperty("name")
    @Column(name = "name")
    String name;
//   String corporations;



}
