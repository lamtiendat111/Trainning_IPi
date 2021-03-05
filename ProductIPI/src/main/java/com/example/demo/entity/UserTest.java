package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class UserTest {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String pass;
	private int age;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserTest(int id, String name, String pass, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
	}
	public UserTest() {
		super();
	}
	
}
