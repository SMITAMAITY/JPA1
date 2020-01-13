package com.lti.ui;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import com.lti.model.Current;
import com.lti.model.Saving;


public class Main {

	public static void main(String[] args) {
		

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		Saving s1= new Saving(10001,"smita",7500, 4);
		Current c1= new Current(1002,"apeksha",65000, 20000);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(s1);
		entityManager.persist(c1);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		

	}

	

}
