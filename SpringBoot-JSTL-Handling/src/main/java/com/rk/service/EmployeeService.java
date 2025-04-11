package com.rk.service;

import java.util.List;
import java.util.Optional;

import com.rk.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
	public Employee getEmployeeById(Integer id);
	public List<Employee> getAllEmployee();
	public Boolean deleteById(Integer id);
	public Optional<Employee> validateEmployee(Integer id, String pass);
}
