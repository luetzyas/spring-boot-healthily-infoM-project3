package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

	@Query("SELECT ts FROM Workout w JOIN w.customer c JOIN w.trainings ts WHERE c.id = ?1 AND ts.level = ?2")
	public List<Training> getTrainingsByCustomerLevel(long id, int level);
	
	@Query("SELECT t FROM Training t WHERE t.level = ?1") 
	public List<Training> getTrainingsByLevel(int level);
	
	@Query("SELECT COUNT(*) FROM Training t WHERE t.category LIKE %?1%") 
	public Integer countByCategory(String category);
}