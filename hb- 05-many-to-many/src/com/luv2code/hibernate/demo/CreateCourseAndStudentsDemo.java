package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			Course course2 = new Course("Science");
			Course course3 = new Course("English");
			Course course4 = new Course("Hindi");
			
			Student s1 = new Student("Kush","Patel","kp@gmail.com");
			Student s2 = new Student("John","Doe","jd@gmail.com");
			System.out.println("Saving the Course = "+course1);
			
			course1.addStudent(s1);
			course1.addStudent(s2);
			
			//Save the students
			System.out.println("Saving Students");
			session.save(s1);
			session.save(s2);
			
			// Save the course
			System.out.println("Saving Courses");
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


