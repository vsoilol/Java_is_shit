public class Main {
    public static void main(String[] args) {
        try {
            Expression expression = new Expression();
            System.out.println("G = " + expression.calculate(args));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
