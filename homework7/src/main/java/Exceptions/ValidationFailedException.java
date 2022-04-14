package Exceptions;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(String errorMessage) {
        super(errorMessage);
    }
}
