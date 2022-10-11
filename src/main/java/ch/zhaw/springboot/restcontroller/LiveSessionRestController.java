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

import ch.zhaw.springboot.entities.LiveSession;
import ch.zhaw.springboot.repositories.LiveSessionRepository;

@RestController
public class LiveSessionRestController {
	
	@Autowired
	private LiveSessionRepository repository;

	@RequestMapping(value = "healthily/liveSessions", method = RequestMethod.GET)
	public ResponseEntity<List<LiveSession>> getAllLiveSessions() {
		List<LiveSession> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<LiveSession>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LiveSession>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "healthily/liveSessions/delete={id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLiveSessionById(@PathVariable("id") long id, RedirectAttributes redirAttrs) {
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
