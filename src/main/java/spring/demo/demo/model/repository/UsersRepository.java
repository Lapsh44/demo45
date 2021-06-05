package spring.demo.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.demo.demo.model.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
}
