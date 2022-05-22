import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConstructionTender {
    private final Map<JobSkill, Integer> employeeRequirements;

    public ConstructionTender(Map<JobSkill, Integer> employeeRequirements) {
        this.employeeRequirements = employeeRequirements;
    }

    public Brigade findCheapBrigadeByEmployeeRequirements(List<Brigade> brigades) {
        List<Brigade> filteredBrigades = getFilteredBrigades(brigades);

        if (filteredBrigades == null) {
            throw new IllegalArgumentException("Cannot find suitable brigades");
        }

        return filteredBrigades
                .stream()
                .reduce((prev, curr) -> prev.getFinancialProposal() < curr.getFinancialProposal() ? prev : curr)
                .get();
    }

    private List<Brigade> getFilteredBrigades(List<Brigade> brigades) {
        List<Brigade> filteredBrigades = new ArrayList<>();

        for (Brigade brigade : brigades) {
            List<Employee> employees = brigade.getEmployees();

            for (Map.Entry<JobSkill, Integer> entry : employeeRequirements.entrySet()) {
                Supplier<Stream<Employee>> neededEmployees = () -> employees
                        .stream()
                        .filter(employee -> employee.getSkills().contains(entry.getKey()));

                if (neededEmployees.get().findAny().isEmpty()) {
                    return null;
                }

                if (neededEmployees.get().count() < entry.getValue()) {
                    return null;
                }

                employees.removeAll(neededEmployees.get().limit(entry.getValue()).toList());
            }

            filteredBrigades.add(brigade);
        }

        return filteredBrigades;
    }
}
