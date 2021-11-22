
public class Main {
    public static void main(String[] args) {
        Chair c = new Chair();
        Cutlery[] cutleries = new Cutlery[5];
        for (int i = 0; i < cutleries.length; i++){
            cutleries[i] = new Cutlery(i);
        }
        Philosopher[] philosophers = new Philosopher[4];
        for (int i = 0; i < philosophers.length; i++){
            philosophers[i] = new Philosopher(i, cutleries[i], cutleries[(i + 1) % 5], c);
        }
        for (int i = 0; i< philosophers.length; i++){
            philosophers[i].start();
        }

    }
}
