package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Session;

public interface SessionRepository  extends JpaRepository<Session, Long>{
	
	@Query("SELECT s FROM Session s WHERE s.topic LIKE %?1%")
	public List<Session> getSessionByTopic(String topic);
}
