package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@Column(name="book_isbn")
	private int bookISBN;
	@Column(name="book_title")
	private String bookTitle;
	@Column(name="book_price")
	private double bookPrice;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="book_author", 
	joinColumns={@JoinColumn(name="book")}, 
	inverseJoinColumns={@JoinColumn(name="author")})
    private List<Author> authors;
	
		
	public int getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Book() {
	
	}
	public Book(int bookISBN, String bookTitle, double bookPrice) {
		super();
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [bookISBN=" + bookISBN + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
	
