package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			int theId = 4;

			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("Instructor == " + theInstructorDetail.getInstructor());
			
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(theInstructorDetail);
			// commit transacation
			session.getTransaction().commit();
			System.out.println("Done !");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
