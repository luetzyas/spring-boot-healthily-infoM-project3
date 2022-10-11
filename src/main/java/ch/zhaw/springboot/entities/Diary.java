package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Diary")
@Table(name = "diary")
public class Diary extends Application{
	
	private String category; //daily, weekly, yearly
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_id")
    private Customer customer;
    
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_diary_id")
	private List<Entry> entries;
	
	public Diary() {
		super();
		this.entries = new ArrayList<Entry>();
	}
	
	public Diary(String name, String sponsor, String category, Customer customer) {
		super(name, sponsor);
		this.category = category;
		this.customer = customer;
		this.entries = new ArrayList<Entry>();
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

}
