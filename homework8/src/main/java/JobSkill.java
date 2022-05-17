import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum JobSkill {
    PAINTER, // Маляр
    IRONWORKER, // Монтажник
    CONCRETE, // Бетонщик
    PLASTERER, // Штукатур
    TILER, // облицовщик
    MASON, // каменщика
    PIPE_LAYER, // монтажников гипсокартона
    MAINTENANCE_ENGINEER; // монтажников трубопроводов.

    public static final List<JobSkill> VALUES = List.of(values());
    public static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static JobSkill randomJobSkill()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
