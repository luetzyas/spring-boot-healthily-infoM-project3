package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Customer;
import ch.zhaw.springboot.entities.Diary;
import ch.zhaw.springboot.models.DiaryRequest;
import ch.zhaw.springboot.repositories.CustomerRepository;
import ch.zhaw.springboot.repositories.DiaryRepository;

@RestController
public class DiaryRestController {

	@Autowired
	private DiaryRepository repository;

	@Autowired
	private CustomerRepository repositoryCustomer;

	@RequestMapping(value = "healthily/diaries", method = RequestMethod.GET)
	public ResponseEntity<List<Diary>> getAllDiaries() {
		List<Diary> result = this.repository.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<List<Diary>>(HttpStatus.NOT_FOUND);
		} 
		
		return new ResponseEntity<List<Diary>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "healthily/diaries/new", method = RequestMethod.POST)
	public ResponseEntity<Diary> createInfection(@RequestBody DiaryRequest diaryRequest) {

		try {
			Customer customer = this.repositoryCustomer.findById(diaryRequest.customer_id).get();
			Diary result = this.repository.save(new Diary(diaryRequest.name, diaryRequest.sponsor, diaryRequest.category, customer));
			return new ResponseEntity<Diary>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Diary>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
