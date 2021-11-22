public class Chair {
    private int chairFree = 5;
    public synchronized void takeChair (int i) throws InterruptedException{
        while (chairFree == 0)
            wait();
        System.out.println("Philosopher " + i + " takes a chair ");
        chairFree--;
    }

    public  synchronized  void dropChair (int i){
        chairFree++;
        System.out.println("Philosopher " + i + " drops the chair");
        notify();
    }
}
