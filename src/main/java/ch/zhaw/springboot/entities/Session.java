package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Session")
@Table(name = "session")
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String topic;
	private String duration;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_liveSession_id")
	private LiveSession liveSession;

	public Session() {
	}
	
	public Session(String topic, String duration, LiveSession liveSession) {
		super();
		this.topic = topic;
		this.duration = duration;
		this.liveSession = liveSession;
	}

	public long getId() {
		return this.id;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
