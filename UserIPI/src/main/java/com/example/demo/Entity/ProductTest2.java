package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class ProductTest2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int soluong;
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public ProductTest2(int id, String name, int soluong) {
		super();
		this.id = id;
		this.name = name;
		this.soluong = soluong;
	}
	public ProductTest2() {
		super();
	}
	
	
}
