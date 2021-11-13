package spboot.web.jpa.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
@Column(name="emp_no")
int employeeId;
@Column(name="emp_name")
String employeeName;
@Column(name="emp_sal")
double salary;
@Column(name="dept_no")
int departmentNo;
public Employee()
{}
public Employee(int employeeId, String employeeName, double salary, int departmentNo) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.salary = salary;
	this.departmentNo = departmentNo;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getDepartmentNo() {
	return departmentNo;
}
public void setDepartmentNo(int departmentNo) {
	this.departmentNo = departmentNo;
}

}
