package com.rk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rk.entity.Employee;
import com.rk.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public String userLoginPage() {
		return "userLogin";
	}
	
	@GetMapping("/add")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Employee emp, Map<String,Object>map, HttpSession session) {
		
		Employee ss  = (Employee)session.getAttribute("emp");
		if(!ObjectUtils.isEmpty(ss)) {
			Employee saveEmployee=  empService.addEmployee(emp);
			
			if(ObjectUtils.isEmpty(saveEmployee)) {
				map.put("errorMsg", "Employee Not Added...");
			}else {
				map.put("succMsg", "Employee Added Successfully...");
			}
			return "redirect:viewAll";
		}else {
			map.put("errorMsg", "Session invalidate login again...");
			return "userLogin";
		}
	
	}
	
	@PostMapping("/uLogin")
	public String login(@RequestParam Integer uid, @RequestParam String pass,HttpSession session,Map<String,Object>map) {
		
		Optional<Employee> emp = empService.validateEmployee(uid, pass);
		if(emp.isPresent()) {
			session.setAttribute("emp", emp.get());
//			session.setMaxInactiveInterval(60);
			map.put("succMsg", "Login successful...");
		}else {
			map.put("errorMsg", "Invalid Credential...");
		}
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("emp");
		session.invalidate();
		return "userLogin";
	}
	
	@GetMapping("/viewAll")
	public String viewAllEmployee(Map<String, Object> map, HttpSession session) {
		
		Employee attribute =(Employee) session.getAttribute("emp");
		if(!ObjectUtils.isEmpty(attribute)) {
			List<Employee> allEmployee = empService.getAllEmployee();
			
			if(!allEmployee.isEmpty() && allEmployee!=null) {
				map.put("list", allEmployee);
			}else {
				map.put("errorMsg", "Employee Not Found...");
			}
			
			return "home";
		}else {
			map.put("errorMsg", "Session invalidate login again...");
			return "userLogin";
		}
		
		
	}
	
	@GetMapping("/updateForm")
	public String employeeUpdateForm(Map<String,Object>map, @RequestParam Integer id, HttpSession session) {
		
		Employee ss  = (Employee)session.getAttribute("emp");
		if(ObjectUtils.isEmpty(ss)) {
			Employee emp = empService.getEmployeeById(id);
			if(!ObjectUtils.isEmpty(emp)) {
				map.put("emp", emp);
			}else {
				map.put("errorMsg", "Employee Not Exists...");
			}
			return "updateForm";
		}else {
			map.put("errorMsg", "Session invalidate login again...");
			return "userLogin";
		}
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp, RedirectAttributes attrs) {
		Employee employee = empService.addEmployee(emp);
		if(!ObjectUtils.isEmpty(employee)) {
			attrs.addFlashAttribute("succMsg","Employee Updated...");
		}else {
			attrs.addFlashAttribute("errorMsg","Employee Not Updated...");
		}
		
		return "redirect:viewAll";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, RedirectAttributes attrs) {
		Boolean del = empService.deleteById(id);
		if(del) {
			attrs.addFlashAttribute("succMsg","Employee Deleted...");
		}else {
			attrs.addFlashAttribute("errorMsg","Employee Not Deleted...");
		}
		
		return "redirect:viewAll";
		
	}
	
}
