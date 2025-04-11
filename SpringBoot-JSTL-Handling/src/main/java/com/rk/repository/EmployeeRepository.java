package com.rk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rk.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("From Employee where id=:uid and pass=:pass")
	public Optional<Employee> validate(@Param("uid") Integer uid,@Param("pass") String pass);
}
