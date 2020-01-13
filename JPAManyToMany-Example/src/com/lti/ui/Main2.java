package com.lti.ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;

public class Main2 {
	static EntityManagerFactory factory; 
	static EntityManager entityManager;
	
public static void loadData(){
	factory = Persistence.createEntityManagerFactory("JPA_PU");
	
	entityManager = factory.createEntityManager();
	
	Author a1= new Author();
	a1.setID(1);
	a1.setName("durjoy");
	
	Author a2= new Author();
	a2.setID(2);
	a2.setName("dunhh");
	 
	Author a3= new Author();
	a3.setID(3);
	a3.setName("dhayj");
	
	
	
	Book b1 = new Book();
	b1.setBookISBN(121);
	b1.setBookTitle("love story");
	b1.setBookPrice(1256);
	
	List<Author> list1 = new ArrayList<>();
	list1.add(a1);
	list1.add(a2);
	b1.setAuthors(list1);
	
	
	Book b2 = new Book();
	b2.setBookISBN(123);
	b2.setBookTitle("horror story");
	b2.setBookPrice(5000);
	
	List<Author> list2 = new ArrayList<>();
	list2.add(a2);
	list2.add(a3);
	b2.setAuthors(list2);
	
	entityManager.getTransaction().begin();
	entityManager.persist(b1);
	entityManager.persist(b2);
	entityManager.getTransaction().commit();
	
}
	public static void main(String[] args) {
loadData();
		
		String jpql="Select book_title from Book b where book_isbn IN (select book_isbn from book_author where author_id IN (select author_id from Author Where author_name= durjoy))";
		
				
		TypedQuery<Book> tquery= entityManager.createQuery(jpql,Book.class);
		List<Book> result1 = tquery.getResultList();
		
		for(Book b : result1){
			System.out.println("Book ISBN :"+ b.getBookISBN());
		    System.out.println("Book Name :"+ b.getBookTitle());
		    System.out.println("Book Price :"+ b.getBookPrice());
		
		List<Author> authors = b.getAuthors() ;
		
		for(Author a : authors){
			System.out.println("Author Id : "+ a.getID());
			System.out.println("Author Id : "+ a.getName());
		}
		System.out.println("__________");
		}

	}


	}

