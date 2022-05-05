
import Functions.Function;

import java.util.Random;

public class SimulatedAnnealing {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";


    private final static double MAX_TEMP = 10000;
    private final static double MIN_TEMP = 1;
    private final static int MAX_RUNS = 2000;
    private final static Random random = new Random();


    private static double findNewState(double oldState) {
        return oldState + random.nextGaussian();
    }

    private static double findProbability(double dE, double temperature) {
        return Math.exp(-dE/temperature);
    }

    public static void optimize(Function function, int numArgs) {

        double[] currentArgs = new double[numArgs];
        double[] newArgs = new double[numArgs];

        // var for arrays' index
        int i;

        // initial arguments for function
        for (i = 0; i < numArgs; i++) {
            currentArgs[i] = random.nextDouble() * 100;
        }

        // best solution
        double[] bestArgs = currentArgs.clone();
        double E_best = function.evaluate(bestArgs);

        // initial temperature
        double currentTemp = MAX_TEMP;
        // counter for cycle
        int k = 0;

        while (currentTemp > MIN_TEMP) {
            k++;

            // decrease temperature
            if (k > MAX_RUNS) {
                currentTemp = 0.95 * currentTemp;
                k = 1;
            }

            // find new solution
            for (i = 0; i < numArgs; i++) {
                newArgs[i] = findNewState(currentArgs[i]);
            }

            double E_old = function.evaluate(currentArgs);
            double E_new = function.evaluate(newArgs);

            // compare with old solution
            double dE = E_new - E_old;

            if (dE <= 0) {
                currentArgs = newArgs.clone();
            }

            double prob = findProbability(dE, currentTemp);
            double rnd = random.nextDouble();

            if (dE > 0 && prob > rnd) {
                currentArgs = newArgs.clone();
            }

            if (E_new < E_best) {
                E_best = E_new;
                bestArgs = newArgs.clone();
            }

        }

        System.out.println(ANSI_CYAN + "Best solution:" + ANSI_RESET);

        for (i = 0; i < currentArgs.length; i++){
            System.out.println("x" + (i+1) + ": " + Math.round(bestArgs[i] * Math.pow(10, 5)) / Math.pow(10, 5));
        }
        System.out.println(ANSI_GREEN + "MINIMUM = " + Math.round(E_best * Math.pow(10, 3)) / Math.pow(10, 3) + ANSI_RESET + "\n");
    }
}