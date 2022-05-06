public class Expression {
    private int a;
    private int p;
    private double m1;
    private double m2;

    public double calculate(String[] parameters) throws NumberFormatException {
        if (!tryParseParameters(parameters)) {
            throw new NumberFormatException("Cannot parse parameters");
        }

        return 4 * Math.pow(Math.PI, 2) * Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2));
    }

    private boolean tryParseParameters(String[] parameters) {
        try {
            a = Integer.parseInt(parameters[0]);
            p = Integer.parseInt(parameters[1]);
            m1 = Double.parseDouble(parameters[2]);
            m2 = Double.parseDouble(parameters[3]);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
