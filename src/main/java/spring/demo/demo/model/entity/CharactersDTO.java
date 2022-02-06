package spring.demo.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
 public class CharactersDTO {

    private List<CharactersPOJO> characters;


}
