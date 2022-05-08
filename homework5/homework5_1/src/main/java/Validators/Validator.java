package Validators;

public interface Validator<T> {
    void check(T toCheck);
}