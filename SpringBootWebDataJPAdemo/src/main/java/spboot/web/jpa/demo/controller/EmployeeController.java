package spboot.web.jpa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import spboot.web.jpa.demo.entity.Employee;
import spboot.web.jpa.demo.service.EmployeeService;
@RequestMapping("/employee")
@Controller
public class EmployeeController {
@Autowired
EmployeeService employeeService;
@GetMapping(value="/{employeeId}",produces="application/json")
public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int employeeId)
{
	//Optional<Employee> emp=employeeService.getEmployee(employeeId);
	//if(emp.isPresent())
	Employee emp=employeeService.getEmployee(employeeId);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	//return new ResponseEntity(null,HttpStatus.NO_CONTENT);
}
@GetMapping(produces="application/json")
public ResponseEntity<List<Employee>> getEmployeeDetails()
{
	return new ResponseEntity<List<Employee>>(employeeService.getEmployees(),HttpStatus.OK);
}
@GetMapping(value="/byDepartmentNo/{departmentNo}",produces="application/json")
public ResponseEntity<List<Employee>> getEmployeesDetailsByDepartmentNo(@PathVariable int departmentNo)
{
return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByDepartmentNo(departmentNo),HttpStatus.OK);
}
@PostMapping(consumes="application/json")
public HttpStatus addEmployeeDetails(@RequestBody Employee employee)
{
	if(employeeService.addOrModifyEmployee(employee))
	    return HttpStatus.OK;
	return HttpStatus.NOT_MODIFIED;
}
@PutMapping(consumes="application/json")
public HttpStatus modifyEmployeeDetails(@RequestBody Employee employee)
{
	if(employeeService.addOrModifyEmployee(employee))
	    return HttpStatus.OK;
	return HttpStatus.NOT_MODIFIED;
}
@DeleteMapping(value="/{employeeId}")
public HttpStatus removeEmployeeDetails(@PathVariable int employeeId)
{
	employeeService.removeEmployee(employeeId);
	return HttpStatus.OK;
}
@DeleteMapping(value="deleteByName/{employeeName}")
public HttpStatus removeByName(@PathVariable String employeeName)
{
	employeeService.removeByName(employeeName);
	return HttpStatus.OK;
}
@DeleteMapping(value="/departmentNo/{departmentNo}/salary/{salary}")
public HttpStatus removeEmployeeDetailsByDepartmentAndSalary(@PathVariable int departmentNo,@PathVariable double salary)
{
employeeService.removeByDepartmentNoAndSalary(departmentNo, salary);
return HttpStatus.OK;
}
@ExceptionHandler(RuntimeException.class)
public HttpStatus exceptionHandlerMethod()
{
	return HttpStatus.NO_CONTENT;
}
}
