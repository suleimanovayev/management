package employees;

import employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"employees.dao", "employees.service.impl", "employees.entity"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {

    @Autowired
    private EmployeeService employeeService;

    public Application(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
