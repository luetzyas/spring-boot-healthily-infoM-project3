package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
