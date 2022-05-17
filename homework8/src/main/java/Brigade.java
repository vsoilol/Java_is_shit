import java.util.*;
import java.util.stream.Collectors;

public class Brigade {
    private final List<Employee> employees;
    private final Integer financialProposal;

    public Brigade(List<Employee> employees, Integer financialProposal){
        this.employees = employees;
        this.financialProposal = financialProposal;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Map<JobSkill, Long> getEmployeesInfo() {
        Map<JobSkill, Long> result = employees.stream()
                .flatMap(product -> product.getSkills().stream())
                .collect(Collectors.groupingBy(group -> group, Collectors.counting()));

        return result;
    }

    public Integer getFinancialProposal() {
        return financialProposal;
    }

    @Override
    public String toString() {
        StringBuilder brigadeView = new StringBuilder();

        for (Employee employee: employees) {
            brigadeView.append(employee).append("\n");
        }

        brigadeView.append("financial proposal: ").append(financialProposal).append("\n");

        return brigadeView.toString();
    }
}
