package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Coach")
@Table(name = "coach")
public class Coach extends User {

	private String subjectArea;
	private int experience;

	public Coach() {
		super();
	}

	public Coach(String name, int age, String gender, String subjectArea, int experience) {
		super(name, age, gender);
		this.subjectArea = subjectArea;
		this.experience = experience;
	}

	public String getSubjectArea() {
		return this.subjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
