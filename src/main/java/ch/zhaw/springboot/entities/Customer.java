package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer extends User {

	private String goal;
	private String insurance;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_customer_id")
	private List<LiveSession> liveSessions;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_customer_id")
	private List<Diary> diaries;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_customer_id")
	private List<Workout> workouts;

	public Customer() {
		super();
		this.liveSessions = new ArrayList<LiveSession>();
		this.diaries = new ArrayList<Diary>();
		this.workouts = new ArrayList<Workout>();
	}

	public Customer(String name, int age, String gender, String goal, String insurance) {
		super(name, age, gender);
		this.goal = goal;
		this.insurance = insurance;
		this.liveSessions = new ArrayList<LiveSession>();
		this.diaries = new ArrayList<Diary>();
		this.workouts = new ArrayList<Workout>();
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public List<LiveSession> getLiveSessions() {
		return this.liveSessions;
	}

	public List<Diary> getDiaries() {
		return this.diaries;
	}

	public List<Workout> getWorkouts() {
		return this.workouts;
	}

}
