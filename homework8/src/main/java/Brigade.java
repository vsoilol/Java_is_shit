import java.util.*;

public class Brigade {
    private final List<Employee> employees;
    private final Integer financialProposal;

    public Brigade(List<Employee> employees, Integer financialProposal){
        this.employees = employees;
        this.financialProposal = financialProposal;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
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
