package spboot.web.jpa.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spboot.web.jpa.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
public void deleteByEmployeeName(String employeeName);
List<Employee> findAllByDepartmentNo(int departmentNo);
@Modifying
@Query("delete from Employee where departmentNo=:departmentNo and salary=:salary")
void deleteByDepartmentNoAndSalary(@Param("departmentNo") int departmentNo,@Param("salary") double salary);
}
