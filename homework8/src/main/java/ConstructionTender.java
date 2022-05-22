import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ConstructionTender {
    private String name;
    private final Map<JobSkill, Long> employeeRequirements;

    public ConstructionTender(String name, Map<JobSkill, Long> employeeRequirements) {
        this.name = name;
        this.employeeRequirements = employeeRequirements;
    }

    public Brigade findCheapBrigadeByEmployeeRequirements(List<Brigade> brigades) {
        Stream<Brigade> suitableBrigades = brigades
                .stream()
                .filter(brigade -> brigade.getEmployeesInfo()
                        .equals(employeeRequirements));

        if(suitableBrigades.findAny().isEmpty()){
            return null;
        }

        return suitableBrigades
                .reduce((prev, curr) -> prev.getFinancialProposal() < curr.getFinancialProposal() ? prev : curr)
                .get();
    }
}
