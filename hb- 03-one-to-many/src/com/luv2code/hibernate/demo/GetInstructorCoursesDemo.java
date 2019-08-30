package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String args[]) {
		
		//create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();
			
		//create session
			Session session = factory.getCurrentSession();
			
			try {
				
				int theId = 1;
				
				//start a transaction
				session.beginTransaction();
				
				Instructor instructor = session.get(Instructor.class, theId);
				
				Course tempCourse1 = new Course("Maths");
				Course tempCourse2 = new Course("Science");
				
				instructor.addCourse(tempCourse1);
				instructor.addCourse(tempCourse2);
				
				session.save(tempCourse1);
				session.save(tempCourse2);
				
				//commit transacation
				session.getTransaction().commit();
				System.out.println("Done !");
				
			} finally {
				session.close();
				factory.close();
			}
	}
}

