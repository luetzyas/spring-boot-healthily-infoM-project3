package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
