import java.util.*;

public class BrigadeBuilder {
    private final Random random = new Random();

    private final int brigadeCount;

    private final int minEmployeeCount;
    private final int maxEmployeeCount;

    private final int maxFinancialProposal;

    public BrigadeBuilder(int brigadeCount, int minEmployeeCount,
                          int maxEmployeeCount, int maxFinancialProposal) {
        this.brigadeCount = brigadeCount;
        this.minEmployeeCount = minEmployeeCount;
        this.maxEmployeeCount = maxEmployeeCount;
        this.maxFinancialProposal = maxFinancialProposal;
    }

    public List<Brigade> getRandomBrigade() {
        List<Brigade> brigades = new ArrayList<>();

        for (int i = 0; i < brigadeCount; i++) {
            brigades.add(new Brigade(getRandomEmployees(), random.nextInt(1, maxFinancialProposal)));
        }

        return brigades;
    }

    private List<Employee> getRandomEmployees() {
        int size = random.nextInt(minEmployeeCount, maxEmployeeCount + 1);

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            employees.add(new Employee("Employee" + i, getRandomJobSkills()));
        }

        return employees;
    }

    private Set<JobSkill> getRandomJobSkills() {
        int size = random.nextInt(1, JobSkill.SIZE + 1);

        List<JobSkill> jobSkills = new ArrayList<>(JobSkill.VALUES);
        Set<JobSkill> randomJobSkills = new HashSet<>();

        for (int i = 0; i < size; i++) {
            JobSkill jobSkill = jobSkills.get(random.nextInt(jobSkills.size()));
            randomJobSkills.add(jobSkill);
            jobSkills.remove(jobSkill);
        }

        return randomJobSkills;
    }
}
