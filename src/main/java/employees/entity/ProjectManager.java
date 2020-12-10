package employees.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("PMD")
@Entity
@DiscriminatorValue("Project_Manager")
@NoArgsConstructor
public class ProjectManager extends Employee {
    public ProjectManager(String firstName, String lastName, BigDecimal salary, Contact contact) {
        super(firstName, lastName, salary, contact);
    }

    public ProjectManager(String firstName, String lastName, String passwordHash, LocalDate lastEntryDate, BigDecimal salary, Contact contact) {
        super(firstName, lastName, passwordHash, lastEntryDate, salary, contact);
    }
}
