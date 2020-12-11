package employees.dao;

import employees.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee create(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByFirstName(String firstName);

    void deleteEmployee(Long id);
}
