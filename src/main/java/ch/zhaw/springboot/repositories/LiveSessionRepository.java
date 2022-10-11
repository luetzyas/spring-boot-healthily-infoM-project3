package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.LiveSession;

public interface LiveSessionRepository extends JpaRepository<LiveSession, Long>  {

}
