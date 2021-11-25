import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Random rand = new Random();
        Chair c = new Chair();


        List<Cutlery> cutleries = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            cutleries.add(new Cutlery(i));

        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int eatingRand = rand.nextInt(4) + 2;
            philosophers.add(new Philosopher(i, cutleries.get(i), cutleries.get((i + 1) % 5), c, eatingRand, semaphore));
            philosophers.get(i).start();
        }
    }
}
