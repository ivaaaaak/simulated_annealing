import Functions.MatyasFunction;
import Functions.RastriginFunction;
import Functions.RosenbrockFunction;

class Main {
    public static void main(String[] args) {
        SimulatedAnnealing.optimize(new RosenbrockFunction(), 2);
        SimulatedAnnealing.optimize(new MatyasFunction(), 2);
        SimulatedAnnealing.optimize(new RastriginFunction(),2);
    }
}