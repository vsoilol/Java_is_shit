public final class ValidationSystem {
    public static <T> boolean validate(T value) {
        if (Integer.class.equals(value.getClass())) {
            return (new IntegerValidator()).isValid((Integer) value);
        } else if (String.class.equals(value.getClass())) {
            return (new StringValidator()).isValid((String) value);
        }
        return false;
    }
}
