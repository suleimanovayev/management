package employees.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("PMD")
@Entity
@DiscriminatorValue("Java_Developer")
@NoArgsConstructor
public class JavaDeveloper extends Employee {

    public JavaDeveloper(String firstName, String lastName, BigDecimal salary, Contact contact) {
        super(firstName, lastName, salary, contact);
    }

    public JavaDeveloper(String firstName, String lastName, String passwordHash, LocalDate lastEntryDate, BigDecimal salary, Contact contact) {
        super(firstName, lastName, passwordHash, lastEntryDate, salary, contact);
    }
}
