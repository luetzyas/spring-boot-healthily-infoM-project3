package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Coach;
import ch.zhaw.springboot.repositories.CoachRepository;

@RestController
public class CoachRestController {

	@Autowired
	private CoachRepository repository;

	@RequestMapping(value = "healthily/coaches", method = RequestMethod.GET)
	public ResponseEntity<List<Coach>> getCoaches() {
		List<Coach> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<Coach>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Coach>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "healthily/coaches/new", method = RequestMethod.POST)
	public ResponseEntity<Coach> creatPerson(@RequestBody Coach newCoach) {
		Coach result = this.repository.save(newCoach);

		return new ResponseEntity<Coach>(result, HttpStatus.OK);
	}
}
