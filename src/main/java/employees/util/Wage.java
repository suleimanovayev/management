package employees.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

public class Wage {

    public static BigDecimal calcAvеrageMonthlySalary(Collection<BigDecimal> yearlySalaries) {

        if (yearlySalaries == null) {
            throw new IllegalArgumentException("Collection cannot be NULL");
        }

        return yearlySalaries.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(yearlySalaries.size()), RoundingMode.CEILING);
    }
}
