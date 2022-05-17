import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructionTender {
    private String name;
    private final Map<JobSkill, Long> employeeRequirements;

    public ConstructionTender(String name, Map<JobSkill, Long> employeeRequirements) {
        this.name = name;
        this.employeeRequirements = employeeRequirements;
    }

    public Brigade findCheapBrigadeByEmployeeRequirements(List<Brigade> brigades) {
        Stream<Brigade> selectedBrigades = brigades
                .stream()
                .filter(brigade -> brigade.getEmployeesInfo()
                        .equals(employeeRequirements));

        if(selectedBrigades.count() == 0){
            return null;
        }

        Brigade cheapBrigade = selectedBrigades
                .reduce((prev, curr) -> prev.getFinancialProposal() < curr.getFinancialProposal() ? prev : curr)
                .get();

        return cheapBrigade;
    }
}
