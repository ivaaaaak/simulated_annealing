package Functions;

public class RosenbrockFunction extends Function {
    @Override
    public double evaluate(double... args) {

        double res = Math.pow((args[0] - 1), 2);
        for (int i = 1; i < args.length; i++){
            res = res + 100 * Math.pow((args[i] - Math.pow(args[i - 1], 2)), 2);
        }

        return res;
    }
}