import java.util.Set;

public class Employee {
    private String name;
    private Set<JobSkill> skills;

    public Employee(String name, Set<JobSkill> skills){
        this.name = name;
        this.skills = skills;
    }

    public Set<JobSkill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Employee " + name + ", skills: " + skills;
    }
}
