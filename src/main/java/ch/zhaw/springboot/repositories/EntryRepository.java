package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
	
	@Query("SELECT e FROM Entry e WHERE e.progress = ?1") 
	public List<Entry> getEntryByProgress(int progress);
	
	//year(e.eventDate) = ?1 and month(e.eventDate) = ?2"
	@Query("SELECT e FROM Entry e WHERE e.date Like %?1") 
	public List<Entry> getEntryByYear(String year);
	
	
	
}
