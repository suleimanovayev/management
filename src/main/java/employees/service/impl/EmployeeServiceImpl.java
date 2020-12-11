package employees.service.impl;

import employees.dao.EmployeeDao;
import employees.dao.EmployeeJpaRepository;
import employees.service.EmployeeService;
import employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeDao, EmployeeService {
    @Autowired
    private EmployeeJpaRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeJpaRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
      return  employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<BigDecimal> getAllSalaries() {
        return employeeRepository.getAllSalaries();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.getEmployeeByFirstName(firstName);
    }

    @Override
    public void update(Employee employee) {
        Employee dataEmployee = employeeRepository.getById(employee.getId());
        dataEmployee.setPasswordHash(employee.getPasswordHash());
        dataEmployee.setSalary(employee.getSalary());
        dataEmployee.setFirstName(employee.getFirstName());
        dataEmployee.setLastName(employee.getLastName());
        dataEmployee.setContact(employee.getContact());
        dataEmployee.setLastEntryDate(employee.getLastEntryDate());
        employeeRepository.save(dataEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
