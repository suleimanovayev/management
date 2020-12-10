package employees.service.impl;

import employees.dao.EmployeeRepository;
import employees.entity.Employee;
import employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
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
