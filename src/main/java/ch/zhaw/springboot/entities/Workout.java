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

@Entity(name = "Workout")
@Table(name = "workout")
public class Workout extends Application{
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_id")
    private Customer customer;
    
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_workout_id")
	private List<Training> trainings;
	
	public Workout() {
		super();
		this.trainings = new ArrayList<Training>();
	}

	public Workout(String name, String sponsor, Customer customer) {
		super(name, sponsor);
		this.customer = customer;
		this.trainings = new ArrayList<Training>();
	}

	public List<Training> getTrainings() {
		return this.trainings;
	}
}
