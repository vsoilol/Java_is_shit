import Exceptions.ValidationFailedException;

import java.util.HashMap;
import java.util.Map;

public final class ValidationSystem {
    private static final Map<Class, Validator> validators = new HashMap<>() {{
        put(Integer.class, new IntegerValidator());
        put(String.class, new StringValidator());
    }};

    public static <T> void validate(T value) throws ValidationFailedException {
        if (!validators.get(value.getClass()).isValid(value)) {
            throw new ValidationFailedException(value.getClass() + " value " + value + " is invalid");
        }
    }
}
