package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Workout;
import ch.zhaw.springboot.repositories.WorkoutRepository;

@RestController
public class WorkoutRestController {
	
	@Autowired
	private WorkoutRepository repository;

	@RequestMapping(value = "healthily/workouts", method = RequestMethod.GET)
	public ResponseEntity<List<Workout>> getAllWorkouts() {
		List<Workout> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<Workout>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Workout>>(result, HttpStatus.OK);
	}
}
