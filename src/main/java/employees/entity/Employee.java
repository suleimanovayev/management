package employees.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("PMD")
@Entity(name = "employees")
@Inheritance
@DiscriminatorColumn
@NoArgsConstructor
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private LocalDate lastEntryDate;
    private BigDecimal salary;

    @Embedded
    private Contact contact;

    public Employee(String firstName, String lastName, BigDecimal salary, Contact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.contact = contact;
    }

    public Employee(String firstName, String lastName, String passwordHash, LocalDate lastEntryDate, BigDecimal salary, Contact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.lastEntryDate = lastEntryDate;
        this.salary = salary;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getLastEntryDate() {
        return lastEntryDate;
    }

    public void setLastEntryDate(LocalDate lastEntryDate) {
        this.lastEntryDate = lastEntryDate;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if (salary.signum() <= 0) {
            throw new IllegalArgumentException("Salary has to be grater then 0 and do not equals NULL");
        }
        this.salary = salary;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", lastEntryDate='" + lastEntryDate + '\'' +
                ", salary=" + salary +
                '}';
    }
}
