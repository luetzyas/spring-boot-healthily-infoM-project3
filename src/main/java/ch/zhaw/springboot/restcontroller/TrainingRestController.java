package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.zhaw.springboot.entities.Training;
import ch.zhaw.springboot.repositories.TrainingRepository;

@RestController
public class TrainingRestController {

	@Autowired
	private TrainingRepository repository;

	@RequestMapping(value = "healthily/trainings", method = RequestMethod.GET)
	public ResponseEntity<List<Training>> getAllTrainings() {
		List<Training> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<Training>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Training>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "healthily/trainings/level={level}", method = RequestMethod.GET)
	public ResponseEntity<List<Training>> getTrainingsByLevel(@PathVariable("level") int level) {
		List<Training> result = this.repository.getTrainingsByLevel(level);

		if (result.isEmpty()) {
			return new ResponseEntity<List<Training>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Training>>(result, HttpStatus.OK);

	}

	@RequestMapping(value = "healthily/trainings/category-like={category}", method = RequestMethod.GET)
	public ResponseEntity<String> countByCategory(@PathVariable("category") String category) {
		int ctrCategory = this.repository.countByCategory(category);
		String result;

		if (ctrCategory < 1) {
			result = " for Trainings like: \"" + category + "\" nothing found";
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		} else {
			result = "Trainings like: \"" + category + "\" found: " + ctrCategory;
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "healthily/trainings/delete={id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTrainingById(@PathVariable("id") long id, RedirectAttributes redirAttrs) {
		boolean exists = repository.existsById(id);

		if (exists) {
			this.repository.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} else {
			redirAttrs.addFlashAttribute("msginfo", "ctl-todo.delete.msginfo.id-not-exist");
			redirAttrs.addFlashAttribute("requestedId", id);

			return new ResponseEntity<String>("redirect:/todo/delete" + id, HttpStatus.CONFLICT);
		}
	}
}
