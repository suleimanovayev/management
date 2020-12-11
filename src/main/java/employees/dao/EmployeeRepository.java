package employees.dao;

import employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getById(Long id);

    @Query(value = "select salary from employees", nativeQuery = true)
    List<BigDecimal> getAllSalaries();

    @Query(value = "select * from employees e where first_name = :firstName", nativeQuery = true)
    Employee getEmployeeByFirstName(@Param("firstName") String firstName);
}
