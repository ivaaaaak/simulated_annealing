package Functions;

public class MatyasFunction extends Function {
    @Override
    public double evaluate(double... args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Number of vars have to be 2 for Matyas function");
        }

        return 0.26 * (args[0] * args[0] + args[1] * args[1]) - 0.48 * args[0] * args[1];

    }
}