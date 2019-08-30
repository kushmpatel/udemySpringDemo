package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
																					.addAnnotatedClass(InstructorDetail.class)
																					.addAnnotatedClass(Course.class)
																					.addAnnotatedClass(Review.class)
																					.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int theId = 10; 
			// start a transaction
			session.beginTransaction();
			
			Course course = session.get(Course.class, 10);
			
			System.out.println("Course Info = "+ course);
			System.out.println("Course Reviews are = "+ course.getReviews());
			
			
			// commit transacation
			session.getTransaction().commit();
			System.out.println("Done !");

		} finally {
			session.close();
			factory.close();
		}
	}
}
