package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository theEmployeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.theEmployeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return theEmployeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> results = theEmployeeRepository.findById(id);
		Employee theEmployee = null;
		if(results.isPresent()) {
			theEmployee = results.get();
		} else {
			throw new RuntimeException("Did not find employee id - "+id );
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		theEmployeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		theEmployeeRepository.deleteById(id);
	}


}
