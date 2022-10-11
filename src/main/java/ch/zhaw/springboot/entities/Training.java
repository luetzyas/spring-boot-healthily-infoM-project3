package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Training")
@Table(name = "training")
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String duration;
	private String category;
	private int level;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_workout_id")
	private Workout workout;
	
	public Training() {
	}

	public Training(String duration, int level, String category, Workout workout) {
		this.duration = duration;
		this.level = level;
		this.category = category;
		this.workout = workout;
	}

	public long getId() {
		return this.id;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
