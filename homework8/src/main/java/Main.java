import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BrigadeBuilder builder = new BrigadeBuilder(5, 1, 5, 10000);

        List<Brigade> brigadeList = builder.getRandomBrigade();


        List<Employee> employees1 = new ArrayList<>() {{
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.CONCRETE, JobSkill.MASON))));
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.MAINTENANCE_ENGINEER, JobSkill.PIPE_LAYER))));
        }};

        List<Employee> employees2 = new ArrayList<>() {{
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.TILER))));
            add(new Employee("Employee1", new HashSet<>(Set.of(JobSkill.TILER, JobSkill.IRONWORKER))));
        }};

        List<Brigade> brigades = new ArrayList<>() {{
            add(new Brigade(employees1, 231));
            add(new Brigade(employees2, 65412));
        }};

        Map<JobSkill, Long> employeeRequirements = new HashMap<>() {{
            put(JobSkill.TILER, 2L);
            put(JobSkill.IRONWORKER, 1L);
            put(JobSkill.MAINTENANCE_ENGINEER, 1L);
            put(JobSkill.CONCRETE, 1L);
            put(JobSkill.MASON, 1L);
            put(JobSkill.PIPE_LAYER, 1L);
        }};

        ConstructionTender tender = new ConstructionTender("Tender", employeeRequirements);

        System.out.println(tender.findCheapBrigadeByEmployeeRequirements(brigades));
    }
}
