package employees.management.dao;

import employees.entity.Contact;
import employees.entity.Employee;
import employees.entity.JavaDeveloper;
import employees.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeRepositoryTest {

    List<JavaDeveloper> javaDeveloperList = Arrays.asList(
            new JavaDeveloper("Adam", "Brown", new Contact("New York", "5-08-23")),
            new JavaDeveloper("Nick", "Smith", new Contact("Los Angeles", "5-037-68")),
            new JavaDeveloper("Anna", "Beil", new Contact("Chicago", "5-12-43")));

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


    }

}
