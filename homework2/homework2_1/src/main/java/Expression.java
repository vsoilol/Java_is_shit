public class Expression {
    private int a;
    private int p;
    private double m1;
    private double m2;

    public Expression(String[] parameters) throws NumberFormatException, IllegalArgumentException {
        validateParameters(parameters);
    }

    public double calculate() throws IllegalArgumentException {
        return 4 * Math.pow(Math.PI, 2) * Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2));
    }

    private void validateParameters(String[] parameters) throws NumberFormatException, IllegalArgumentException {
        if (parameters.length != 4) {
            throw new IllegalArgumentException(ExceptionMessages.PARAMETERS_LENGTH_INCORRECT);
        }

        if (!tryParseParameters(parameters)) {
            throw new NumberFormatException(ExceptionMessages.CANNOT_PARSE_PARAMETERS);
        }

        if (!areParametersValid()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PARAMETERS);
        }
    }

    private boolean areParametersValid() {
        if (p == 0) {
            return false;
        }

        if (m1 == 0 && m2 == 0) {
            return false;
        }

        if (m1 < 0 && m2 > 0 && Math.abs(m1) == m2) {
            return false;
        }

        if (m2 < 0 && m1 > 0 && Math.abs(m2) == m1) {
            return false;
        }

        return true;
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
