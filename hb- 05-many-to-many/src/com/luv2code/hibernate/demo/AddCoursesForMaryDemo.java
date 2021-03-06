package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
																					.addAnnotatedClass(InstructorDetail.class)
																					.addAnnotatedClass(Course.class)
																					.addAnnotatedClass(Review.class)
																					.addAnnotatedClass(Student.class)
																					.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int theId = 2;
			// start a transaction
			session.beginTransaction();

			Student tempStudent = session.get(Student.class, theId);
			Course c1 = new Course ("Sanskrit");
			Course c2 = new Course ("Hindi");
			
			c1.addStudent(tempStudent);
			c2.addStudent(tempStudent);
			
			//Save the Courses
			session.save(c1);
			session.save(c2);
			
			// commit transacation
			session.getTransaction().commit();
			System.out.println("Done !");

		} finally {
			session.close();
			factory.close();
		}
	}
}


