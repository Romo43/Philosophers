public class Philosopher extends Thread {

    private int id;
    private Cutlery left, right;
    private Chair c;
    private int eating;

    public Philosopher(int id, Cutlery left, Cutlery right, Chair c, int eating) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.c = c;
        this.eating = eating;
    }

    public void run() {
        try {
            c.takeChair(id);

            System.out.println("Philosopher " + id + " going to eat ");

            left.takeCutlery(id, null);
            right.takeCutlery(id, left);

            System.out.println("Philosopher " + id + " going to eat for " + eating + " seconds");
            Thread.sleep(eating * 1000L);

            left.dropCutlery(id);
            right.dropCutlery(id);
            c.dropChair(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
