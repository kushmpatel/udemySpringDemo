package com.luv2code.hibernate.demo;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
				
				Query<Instructor> query = session.createQuery("select i from Instructor i "
															  +"JOIN FETCH i.listCourses "
															  +"where i.id=:theInstructorId",Instructor.class);
				query.setParameter("theInstructorId", theId);
				
				Instructor instructor = query.getSingleResult();
				
				System.out.println("Instructor: = "+instructor);
				
				
				//commit transacation
				session.getTransaction().commit();
				System.out.println("Done !");
				
			} finally {
				session.close();
				factory.close();
			}
	}
}

