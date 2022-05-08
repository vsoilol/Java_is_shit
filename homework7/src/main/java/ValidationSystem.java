
import java.util.HashMap;
import java.util.Map;

public final class ValidationSystem {
    private static final Map<Class, Validator> validators = new HashMap<>() {{
        put(Integer.class, new IntegerValidator());
        put(String.class, new StringValidator());
    }};

    public static <T> boolean validate(T value) {
        if(!validators.containsKey(value.getClass())){
            return false;
        }

        return validators.get(value.getClass()).isValid(value);
    }
}
