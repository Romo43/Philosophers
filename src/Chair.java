public class Chair {
    public int chairFree = 6;

    public synchronized void takeChair(int i) throws InterruptedException {
        while (chairFree == 0)
            wait();

        System.out.println("Philosopher " + i + " takes a chair ");
        chairFree--;

        if (chairFree > 0)
            wait();

        else if (chairFree == 0) {
            System.out.println("All philosophers are sitting");
            notifyAll();
        }
    }

    public synchronized void dropChair(int i) {
        chairFree++;
        System.out.println("Philosopher " + i + " drops the chair");
        notify();
    }
}
