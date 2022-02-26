public class Main {
    public static void main(String[] args) {
        try {
            SimpleMenu menu = new SimpleMenu(args);
            System.out.println("Result: " + menu.invokeOperation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
