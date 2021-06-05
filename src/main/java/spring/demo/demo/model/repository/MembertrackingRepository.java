package spring.demo.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.demo.demo.model.entity.Membertracking;


public interface MembertrackingRepository extends JpaRepository<Membertracking, String> {
}
