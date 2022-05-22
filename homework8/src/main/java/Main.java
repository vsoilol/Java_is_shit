import java.util.*;

public class Main {
    public static void main(String[] args) {
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

        Map<JobSkill, Integer> employeeRequirements = new HashMap<>() {{
            put(JobSkill.MAINTENANCE_ENGINEER, 1);
            put(JobSkill.MASON, 1);
        }};

        ConstructionTender tender = new ConstructionTender(employeeRequirements);

        try {
            System.out.println(tender.findCheapBrigadeByEmployeeRequirements(brigades));
        }
        catch (IllegalArgumentException exception){
            System.out.println("Tender is closed");
        }
    }
}
