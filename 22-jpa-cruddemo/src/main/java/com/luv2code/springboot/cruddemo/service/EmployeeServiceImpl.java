package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO theEmployeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl")EmployeeDAO theEmployeeDAO) {
		this.theEmployeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return theEmployeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return theEmployeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		theEmployeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		theEmployeeDAO.deleteById(id);
	}


}
