package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	private int age;
	private String city;
	private String name;
	
	
	public Person() {
		
	}
	
	public Person(int emp_id, int age, String city, String name) {
		super();
		this.emp_id = emp_id;
		this.age = age;
		this.city = city;
		this.name = name;
	}



	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [emp_id=" + emp_id + ", age=" + age + ", city=" + city + ", name=" + name + "]";
	}
	

	
}
