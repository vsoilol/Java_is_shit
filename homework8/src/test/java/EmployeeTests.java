import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTests {
    private Employee employee;

    private final String NAME = "Employee1";
    private final Set<JobSkill> JOB_SKILLS = Set.of(JobSkill.CONCRETE, JobSkill.TILER);

    @BeforeEach
    public void init() {
        employee = new Employee(NAME, JOB_SKILLS);
    }

    @Test
    void testGetSkillsShouldReturnSkills(){
        Set<JobSkill> actual = employee.getSkills();

        assertEquals(JOB_SKILLS, actual);
    }

    @Test
    void testToStringShouldWorkAsExpected(){
        String expected = "Employee " + NAME + ", skills: " + JOB_SKILLS;

        String actual = employee.toString();

        assertEquals(expected, actual);
    }
}
