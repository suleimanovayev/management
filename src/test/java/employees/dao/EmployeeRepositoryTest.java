package employees.dao;

import employees.service.EmployeeService;
import employees.entity.Contact;
import employees.entity.Employee;
import employees.entity.HR;
import employees.entity.JavaDeveloper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeRepositoryTest {

    List<JavaDeveloper> javaDeveloperList = Arrays.asList(
            new JavaDeveloper("Adam", "Brown", new BigDecimal("127.00"), new Contact("New York", "5-08-23")),
            new JavaDeveloper("Nick", "Smith", new BigDecimal("127.00"), new Contact("Los Angeles", "5-037-68")),
            new JavaDeveloper("Anna", "Beil", new BigDecimal("127.00"), new Contact("Chicago", "5-12-43")));

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void createEmployeeTest() {
        javaDeveloperList.forEach(javaDeveloper -> employeeService.create(javaDeveloper));
        List<Employee> employees = employeeService.getAllEmployees();

        assertThat(employees).isNotNull();
        assertThat(employees).isNotEmpty();
        assertThat(employees).isEqualTo(javaDeveloperList);
    }

    @Test
    public void findByIdTest() {
        Employee hrEmployee = new HR("Alisa", "Lane", new BigDecimal("500.15"), new Contact("Vancouver", "45-19-68"));
        Employee hrDbEmployee = employeeService.create(hrEmployee);

        assertThat(employeeService.getEmployeeById(hrDbEmployee.getId())).isNotNull();
        assertThat(employeeService.getEmployeeById(hrDbEmployee.getId())).isEqualTo(hrDbEmployee);
        assertEquals(employeeService.getEmployeeById(hrDbEmployee.getId()).getSalary().compareTo(hrDbEmployee.getSalary()), 0);
    }

    @Test
    public void getAllSalariesTest() {
        javaDeveloperList.forEach(javaDeveloper -> employeeService.create(javaDeveloper));
        List<BigDecimal> salaries = javaDeveloperList.stream().map(Employee::getSalary).collect(Collectors.toList());

        assertThat(employeeService.getAllSalaries()).isNotEmpty();
        assertThat(employeeService.getAllSalaries()).isNotNull();
        assertThat(employeeService.getAllSalaries().size()).isEqualTo(salaries.size());
    }

    @Test
    public void findByNameTest() {
        Employee employee = new JavaDeveloper("Melissa", "White", new BigDecimal("1100.00"), new Contact("London", "32-84-45"));
        employeeService.create(employee);

        assertThat(employeeService.getEmployeeByFirstName("Melissa")).isEqualTo(employee);
    }
}
