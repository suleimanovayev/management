package employees.service;

import employees.dao.EmployeeDao;
import employees.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService extends EmployeeDao {
    List<BigDecimal> getAllSalaries();

    void update(Employee employee);
}
