package ch.zhaw.springboot.models;

public class DiaryRequest {

	
	public String name;
	public String sponsor;
	public String category;
	public long customer_id;
	
	public DiaryRequest(String name, String sponsor, String category, long customer_id) {
		this.name = name;
		this.sponsor = sponsor;
		this.category = category;
		this.customer_id = customer_id;
	}
}
