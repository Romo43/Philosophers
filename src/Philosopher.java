import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    private int id;
    private Cutlery left, right;
    private Chair c;
    private int eating;
    private Semaphore semaphore;

    public Philosopher(int id, Cutlery left, Cutlery right, Chair c, int eating, Semaphore semaphore) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.c = c;
        this.eating = eating;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            c.takeChair(id);
            semaphore.release();

            while (c.chairFree > 0) {
                Thread.sleep(1000);
            }

            boolean first = true;
            while (left.free != id || right.free != id) {
                semaphore.acquire();

                if (left.free == -1 && right.free == -1) {
                    left.takeCutlery(id);
                    right.takeCutlery(id);
                    System.out.println("Philosopher " + id + " going to eat for " + eating + " seconds\n");
                }
                else if(first){
                    first = false;
                    System.out.println("Philosopher " + id + " waiting cutlery " + left.id + " and " + right.id + "\n");
                }

                semaphore.release();
                Thread.sleep(1000);
            }

            Thread.sleep(eating * 1000L);

            semaphore.acquire();
            left.dropCutlery(id);
            right.dropCutlery(id);
            c.dropChair(id);
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
