package com.election.voter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Voter {
	@Id
	private int id;
	private String name;
	private int age;
	private String gender;
	private String area;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", area=" + area + "]";
	}
	public Voter(int id, String name, int age, String gender, String area) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.area = area;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
