package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	static int studentId = 1 ;
	public static void main(String args[]) {
		
		//create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			
		//create session
			Session session = factory.getCurrentSession();
			

			try {
				//start a transaction
				session.beginTransaction();
				
				Student myStudent = session.get(Student.class, studentId);
				myStudent.setFirstName("Scooby");
				session.getTransaction().commit();
				
				// New Code
				session = factory.getCurrentSession();
				session.beginTransaction();
				session.createQuery("update Student set email='kp@ooyala.com'").executeUpdate();
				session.getTransaction().commit();
				
				
				System.out.println("Done !");
				
			} finally {
				factory.close();
			}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}
}
