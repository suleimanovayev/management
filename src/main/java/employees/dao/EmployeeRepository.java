package employees.dao;

import employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getById(Long id);

    @Query("select salary from employees")
    List<BigDecimal> getAllSalaries();
}
