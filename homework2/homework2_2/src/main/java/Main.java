public class Main {
    public static void main(String[] args) {
        try {
            SimpleMenu menu = new SimpleMenu();
            System.out.println("Result: " + menu.invokeOperation(args));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
