package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "LiveSession")
@Table(name = "liveSession")
public class LiveSession extends Application{
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) 
    private List<Coach> coaches;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_id")
    private Customer customer;
    
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_liveSession_id")
	private List<Session> sessions;
	
	public LiveSession() {
		super();
		this.coaches = new ArrayList<Coach>(); 
		this.sessions = new ArrayList<Session>();
	}

	public LiveSession(String name, String sponsor, Customer customer) {
		super(name, sponsor);
		this.customer = customer;
		this.coaches = new ArrayList<Coach>(); 
		this.sessions = new ArrayList<Session>();
	}

	public List<Coach> getCoach() {
		return this.coaches;
	}

	public void setCoach(List<Coach> coaches) {
		this.coaches = coaches;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}
}
