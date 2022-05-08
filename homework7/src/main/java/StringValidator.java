public class StringValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        return value.length() > 0 && Character.isUpperCase(value.charAt(0));
    }
}
