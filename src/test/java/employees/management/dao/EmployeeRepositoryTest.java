package employees.management.dao;

import employees.entity.Contact;
import employees.entity.Employee;
import employees.entity.HR;
import employees.entity.JavaDeveloper;
import employees.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
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
        Employee hrEmployee = new HR("Alisa", "Lane", new BigDecimal(134), new Contact("Vancouver", "45-19-68"));
        Employee hrDbEmployee = employeeService.create(hrEmployee);

        assertThat(employeeService.getEmployeeById(hrDbEmployee.getId())).isNotNull();
        assertThat(employeeService.getEmployeeById(hrDbEmployee.getId())).isEqualTo(hrDbEmployee);

    }

    @Test
    public void getAllSalariesTest() {
        javaDeveloperList.forEach(javaDeveloper -> employeeService.create(javaDeveloper));
        List<BigDecimal> salaries = javaDeveloperList.stream().map(Employee::getSalary).collect(Collectors.toList());

        assertThat(employeeService.getAllSalaries()).isNotEmpty();
        assertThat(employeeService.getAllSalaries()).isNotNull();
        assertThat(employeeService.getAllSalaries().size()).isEqualTo(salaries.size());
        assertThat(employeeService.getAllSalaries()).isEqualTo(salaries);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSalaryNullException() {
        new HR("Alisa", "Lane", null, new Contact("Vancouver", "45-19-68"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSalaryEmptyException() {
        new HR("Alisa", "Lane", new BigDecimal(0), new Contact("Vancouver", "45-19-68"));
    }
}
