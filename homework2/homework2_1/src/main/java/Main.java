public class Main {
    public static void main(String[] args) {
        try {
            Expression expression = new Expression(args);
            System.out.println("G = " + expression.calculate());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
