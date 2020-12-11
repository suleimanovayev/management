package employees.entity;

import org.junit.Test;

import java.math.BigDecimal;

public class EmployeeTest {


    @Test(expected = IllegalArgumentException.class)
    public void testSalaryNullException() {
        new HR("Alisa", "Lane", null, new Contact("Vancouver", "45-19-68"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSalaryEmptyException() {
        new HR("Alisa", "Lane", new BigDecimal(0), new Contact("Vancouver", "45-19-68"));
    }
}
