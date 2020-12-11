package employees.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("PMD")
@Entity
@DiscriminatorValue("HR")
@NoArgsConstructor
public class HR extends Employee {
    public HR(String firstName, String lastName, BigDecimal salary, Contact contact) {
        super(firstName, lastName, salary, contact);
    }

    public HR(String firstName, String lastName, String passwordHash) {
        super(firstName, lastName, passwordHash);
    }
}
