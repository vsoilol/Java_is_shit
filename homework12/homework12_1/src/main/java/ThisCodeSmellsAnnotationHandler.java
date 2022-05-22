import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ThisCodeSmellsAnnotationHandler {
    public static void handle(Class<?> someObject) {
        printClassInfo(someObject);

        Map<String, Integer> reviewerCount = new HashMap<>();

        putClassAnnotationInfo(someObject, reviewerCount);

        putMethodsAnnotationInfo(someObject, reviewerCount);

        putFieldsAnnotationInfo(someObject, reviewerCount);

        reviewerCount.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    private static void printClassInfo(Class<?> someObject) {
        System.out.println("Class name: " + someObject.getName());

        System.out.println("Method names:");
        Arrays.stream(someObject.getDeclaredMethods())
                .forEach(method -> System.out.println("\t" + method.getName()));

        System.out.println("Field names:");
        Arrays.stream(someObject.getDeclaredFields())
                .forEach(field -> System.out.println("\t" + field.getName()));
    }

    private static void putFieldsAnnotationInfo(Class<?> someObject, Map<String, Integer> reviewerCount) {
        Field[] declaredFields = someObject.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmells thisCodeSmells = field.getAnnotation(ThisCodeSmells.class);
                putReviewerCount(reviewerCount, thisCodeSmells.reviewer());
            }
        }
    }

    private static void putMethodsAnnotationInfo(Class<?> someObject, Map<String, Integer> reviewerCount) {
        Method[] declaredMethods = someObject.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmells thisCodeSmells = method.getAnnotation(ThisCodeSmells.class);
                putReviewerCount(reviewerCount, thisCodeSmells.reviewer());
            }
        }
    }

    private static void putClassAnnotationInfo(Class<?> someObject, Map<String, Integer> reviewerCount) {
        if (someObject.isAnnotationPresent(ThisCodeSmells.class)) {
            ThisCodeSmells thisCodeSmells = someObject.getAnnotation(ThisCodeSmells.class);
            putReviewerCount(reviewerCount, thisCodeSmells.reviewer());
        }
    }

    private static void putReviewerCount(Map<String, Integer> reviewerCount, String reviewer) {
        reviewerCount.put(reviewer, reviewerCount.getOrDefault(reviewer, 0) + 1);
    }
}
