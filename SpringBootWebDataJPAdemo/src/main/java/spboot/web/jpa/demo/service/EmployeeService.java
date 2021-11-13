package spboot.web.jpa.demo.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.demo.entity.Employee;
import spboot.web.jpa.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

@Transactional(readOnly=true)
public Employee getEmployee(int employeeId)
{
	//return employeeRepository.findById(employeeId);
	Optional<Employee> optEmp= employeeRepository.findById(employeeId);
	if(optEmp.isPresent()) return optEmp.get();
	throw new RuntimeException("Employee does not EXIST");
}
@Transactional(readOnly=true)
public List<Employee> getEmployees()
{
List<Employee> elist=employeeRepository.findAll();
if(elist.size()>0) return elist;
 throw new RuntimeException("no data found");
}
@Transactional
public boolean addOrModifyEmployee(Employee employee)
{
	Employee emp = employeeRepository.save(employee);
	return emp!=null;
}
@Transactional
public void removeEmployee(int employeeId)
{
	employeeRepository.deleteById(employeeId);
}
@Transactional
public void removeByName(String employeeName)
{
	employeeRepository.deleteByEmployeeName(employeeName);
}
@Transactional
public void removeByDepartmentNoAndSalary(int departmentNo,double salary)
{
	employeeRepository.deleteByDepartmentNoAndSalary(departmentNo,salary);
}
@Transactional(readOnly=true)
public List<Employee> getEmployeesByDepartmentNo(int departmentNo)
{
return employeeRepository.findAllByDepartmentNo(departmentNo);	
}
}
