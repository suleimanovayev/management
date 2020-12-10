package employees.service;

import employees.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> getAllEmployees();

    List<BigDecimal> getAllSalaries();

    Employee getEmployeeById(Long id);

    void update(Employee employee);

    void deleteEmployee(Long id);
}
