package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute And return the results

		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int id) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Employee employee = currentSession.get(Employee.class, id);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create the query
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);

		theQuery.executeUpdate();
	}

}
