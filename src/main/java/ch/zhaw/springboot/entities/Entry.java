package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Entry")
@Table(name = "entry")
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String date;
	private String note;
	private int progress;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_diary_id")
	private Diary diary;
	
	public Entry() {
	}

	public Entry(String date, String note, int progress, Diary diary) {
		this.date = date;
		this.note = note;
		this.progress = progress;
		this.diary = diary;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getProgress() {
		return this.progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}
