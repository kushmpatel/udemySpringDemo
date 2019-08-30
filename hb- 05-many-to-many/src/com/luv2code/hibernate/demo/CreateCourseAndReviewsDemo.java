package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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

			// start a transaction
			session.beginTransaction();

			// Create a course
			Course course1 = new Course("Maths");
			/*
			 * Course course2 = new Course("Science"); Course course3 = new
			 * Course("English");
			 */
			
			// Add some reviews
			Review review = new Review("Nice course.");
			Review review1 = new Review("Very good.");
			Review review2 = new Review("Good Job");
			course1.addReview(review);
			course1.addReview(review1);
			course1.addReview(review2);
			
			System.out.println("Saving the Course = "+course1);
			
			// Save the course
			session.save(course1);
			// commit transacation
			session.getTransaction().commit();
			System.out.println("Done !");

		} finally {
			session.close();
			factory.close();
		}
	}
}
