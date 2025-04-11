package com.rk.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Employee;
import com.rk.repository.EmployeeRepository;
import com.rk.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> byId = repo.findById(id);
		return byId.get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Boolean deleteById(Integer id) {
			Optional<Employee> byId = repo.findById(id);
			if(byId.isPresent()) {
				repo.deleteById(id);
				return true;
			}
		return false;
	}

	@Override
	public Optional<Employee> validateEmployee(Integer id, String pass) {
		return repo.validate(id, pass);
	}
	
}
