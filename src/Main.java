import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Chair c = new Chair();

        List<Cutlery> cutleries = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            cutleries.add(new Cutlery(i));

        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int eatingRand = rand.nextInt(5 + 1) + 1;
            philosophers.add(new Philosopher(i, cutleries.get(i), cutleries.get((i + 1) % 5), c, eatingRand));
            philosophers.get(i).start();
        }
    }
}
