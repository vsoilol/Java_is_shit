import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConstructionTenderTests {
    private ConstructionTender tender;

    private final Map<JobSkill, Integer> EMPLOYEE_REQUIREMENTS = new HashMap<>() {{
        put(JobSkill.MAINTENANCE_ENGINEER, 1);
        put(JobSkill.MASON, 1);
    }};

    @BeforeEach
    public void init() {
        tender = new ConstructionTender(EMPLOYEE_REQUIREMENTS);
    }

    @Test
    public void testFindCheapBrigadeByEmployeeRequirementsShouldThrowExceptionWhenEmployeeCountIsLessThenRequirements() {
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee("Em1", Set.of(JobSkill.MASON)));
        }};

        List<Brigade> brigades = new ArrayList<>() {{
            add(new Brigade(employees, 465));
        }};

        assertThrows(IllegalArgumentException.class, () -> tender.findCheapBrigadeByEmployeeRequirements(brigades));
    }

    @Test
    public void testFindCheapBrigadeByEmployeeRequirementsShouldThrowExceptionWhenJobSkillsIsNotSuitable() {
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee("Em1", Set.of(JobSkill.CONCRETE, JobSkill.PAINTER)));
            add(new Employee("Em2", Set.of(JobSkill.MAINTENANCE_ENGINEER, JobSkill.MASON)));
        }};

        List<Brigade> brigades = new ArrayList<>() {{
            add(new Brigade(employees, 465));
        }};

        assertThrows(IllegalArgumentException.class, () -> tender.findCheapBrigadeByEmployeeRequirements(brigades));
    }

    @Test
    public void testFindCheapBrigadeByEmployeeRequirementsShouldWorkAsExpected() {
        List<Employee> employees1 = new ArrayList<>() {{
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.CONCRETE, JobSkill.MASON))));
            add(new Employee("Employee2", new HashSet<>(Set.of(JobSkill.MAINTENANCE_ENGINEER, JobSkill.PIPE_LAYER))));
        }};

        List<Employee> employees2 = new ArrayList<>() {{
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.TILER, JobSkill.MASON))));
            add(new Employee("Employee2", new HashSet<>(Set.of(JobSkill.TILER, JobSkill.IRONWORKER, JobSkill.MAINTENANCE_ENGINEER))));
        }};

        List<Brigade> brigades = new ArrayList<>() {{
            add(new Brigade(employees1, 231));
            add(new Brigade(employees2, 65412));
        }};

        Brigade actual = tender.findCheapBrigadeByEmployeeRequirements(brigades);

        assertEquals(231, actual.getFinancialProposal());
    }
}
