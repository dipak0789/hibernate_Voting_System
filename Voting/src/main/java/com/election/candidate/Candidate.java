package com.election.candidate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Candidate {
	
    @Id
	private int id;
	private String name;
	private int age;
	private String party;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Candidate(int id, String name, int age, String party) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.party = party;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", age=" + age + ", party=" + party + "]";
	}
	
	public Candidate() {
		
	}

	
	
}
