public class Chair {
    public int chairFree = 6;

    public Chair() {
    }

    public void takeChair(int i) {
        System.out.println("Philosopher " + i + " takes a chair ");
        chairFree--;

        if (chairFree == 0) {
            System.out.println("\nAll philosophers are sitting\n");
        }
    }

    public void dropChair(int i) {
        System.out.println("Philosopher " + i + " drops the chair ****************************\n");
    }
}
