package com.kodnest.One_to_Many_Mapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Kodneststudent;


/**
 * Hello world!
 */
public class App {
public static void main(String[] args) {
		
		//Load the Configuration
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Open Session
		Session session = factory.openSession();
		
		//Begin Transaction
		Transaction transaction = session.beginTransaction();
		
		//Perform operation
		Course course1 = new Course("Java"); 
		Course course2 = new Course("DSA");
		Course course3 = new Course("SQL");
		Course course4 = new Course("Frontend");
		
		ArrayList<Course> list = new ArrayList<Course>();
		list.add(course1);
		list.add(course2);
		list.add(course3);
		list.add(course4);
		
		Kodneststudent student1 = new Kodneststudent("Omkar", "on@om.com", 998877);
	
		student1.setCourses(list);
		
		course1.setStudent(student1);
		course2.setStudent(student1);
		course3.setStudent(student1);
		course4.setStudent(student1);
		
		session.persist(student1);
		
		//Commit Transaction
		transaction.commit();
		
		//close session and SessionFactory
		session.close();
		factory.close();
		
	}
}
