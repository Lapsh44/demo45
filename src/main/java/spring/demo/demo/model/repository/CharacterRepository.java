package spring.demo.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.demo.model.entity.Character;


public interface CharacterRepository extends JpaRepository<Character, String> {
}
