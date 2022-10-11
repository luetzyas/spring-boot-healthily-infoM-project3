package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Entry;
import ch.zhaw.springboot.repositories.EntryRepository;

@RestController
public class EntryRestController {
	
	@Autowired
	private EntryRepository repository;

	@RequestMapping(value = "healthily/entries", method = RequestMethod.GET)
	public ResponseEntity<List<Entry>> getAllEntries() {
		List<Entry> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<Entry>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Entry>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "healthily/entries/progress={progress}", method = RequestMethod.GET)
	public ResponseEntity<List<Entry>> getEntryByProgress(@PathVariable("progress") int progress) {
		List<Entry> result = this.repository.getEntryByProgress(progress);

		if (result.isEmpty()) {
			return new ResponseEntity<List<Entry>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Entry>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "healthily/entries/year={year}", method = RequestMethod.GET)
	public ResponseEntity<List<Entry>> getEntryByYear(@PathVariable("year") String year) {
		List<Entry> result = this.repository.getEntryByYear(year);
		
		if (result.isEmpty()) {
			return new ResponseEntity<List<Entry>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Entry>>(result, HttpStatus.OK);
	}
}
