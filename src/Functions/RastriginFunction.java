package Functions;

public class RastriginFunction extends Function{
    @Override
    public double evaluate(double... args) {

        double res = 0;
        int A = 10;

        for (double arg : args) {
            res = res + arg * arg - (A * Math.cos(2 * Math.PI * arg));
        }

        res = (A * args.length) + res;

        return res;
    }
}