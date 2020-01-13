package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
public class Author {
	@Id
	@Column(name="author_id")
	private int ID;
	@Column(name="author_name")
	private String name;
	
	@ManyToMany(mappedBy="authors")
	private List<Book> books;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author() {
		
	
	}
	public Author(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Author [ID=" + ID + ", name=" + name + "]";
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
