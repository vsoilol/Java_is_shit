import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrigadeTests {
    private Brigade brigade;

    private final Integer FINANCIAL_PROPOSAL = 222;
    private final List<Employee> EMPLOYEES = new ArrayList<>() {{
        add(new Employee("Em1", Set.of(JobSkill.CONCRETE, JobSkill.PAINTER)));
        add(new Employee("Em2", Set.of(JobSkill.MAINTENANCE_ENGINEER, JobSkill.MASON)));
    }};

    @BeforeEach
    public void init() {
        brigade = new Brigade(EMPLOYEES, FINANCIAL_PROPOSAL);
    }

    @Test
    void testGetEmployeesShouldWorkAsExpected(){
        List<Employee> actual = brigade.getEmployees();

        assertEquals(EMPLOYEES, actual);
    }

    @Test
    void testGetFinancialProposalShouldWorkAsExpected(){
        Integer actual = brigade.getFinancialProposal();

        assertEquals(FINANCIAL_PROPOSAL, actual);
    }

    @Test
    void testToStringShouldWorkAsExpected(){
        String expected = "Employee Em1, skills: [CONCRETE, PAINTER]\n" +
                "Employee Em2, skills: [MAINTENANCE_ENGINEER, MASON]\n" +
                "financial proposal: 222\n";

        String actual = brigade.toString();

        assertEquals(expected, actual);
    }
}
