package demo.testexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.testexample.model.Employee;
import demo.testexample.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Value("${key}")
	String str;

	@GetMapping("/getall")
	public List<Employee> getAllEmployee() {
		List<Employee> lst = employeeService.getAllEmployee();
		System.out.println(str);
		return lst;

	}
	
	@PostMapping("/post")
public String postEmployee(@RequestBody Employee emp) {
		employeeService.postEmployee(emp);
		return "employee saved successfully";
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@RequestBody Employee emp,@RequestParam Integer id) {
			employeeService.updateEmployee(emp,id);
			return "employee updated successfully";
		}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
			employeeService.deleteEmployee(id);
			return "employee deleted successfully";
		}
	
	
	
	
	
	
}
