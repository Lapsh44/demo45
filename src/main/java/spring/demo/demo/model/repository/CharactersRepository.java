package spring.demo.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.demo.model.entity.CharactersPOJO;


public interface CharactersRepository extends JpaRepository<CharactersPOJO, Long> {

}
