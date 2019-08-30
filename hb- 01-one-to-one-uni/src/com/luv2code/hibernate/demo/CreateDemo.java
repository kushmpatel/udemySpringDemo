package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String args[]) {
		
		//create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.buildSessionFactory();
			
		//create session
			Session session = factory.getCurrentSession();
			
			try {
				
				
			/*
			 * //create a Instructor object Instructor theInstructor = new
			 * Instructor("Kush","Patel","kp@kp.com");
			 * 
			 * //create a InstructorDetail object InstructorDetail theInstructorDetail = new
			 * InstructorDetail("kp@youtube.com","acting");
			 * 
			 * theInstructor.setInstructorDetail(theInstructorDetail);
			 */
				
				//create a Instructor object
				Instructor theInstructor = new Instructor("Sandy","Patel","sa@asite.com");
				
				//create a InstructorDetail object
				InstructorDetail theInstructorDetail = new InstructorDetail("sandy@youtube.com","reading");
				
				theInstructor.setInstructorDetail(theInstructorDetail);
				
				//start a transaction
				session.beginTransaction();
				
				//save the student object
				System.out.println("Saving a Instructor");
				session.save(theInstructor);
				
				//commit transacation
				session.getTransaction().commit();
				System.out.println("Done !");
				
			} finally {
				factory.close();
			}
	}
}
