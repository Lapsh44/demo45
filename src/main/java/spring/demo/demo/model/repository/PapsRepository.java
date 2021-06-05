package spring.demo.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.demo.model.entity.Paps;

public interface PapsRepository extends JpaRepository<Paps, String> {
}
