public class Cutlery {
    private int id;
    private boolean free = true;

    public Cutlery (int id){
        this.id = id;
    }

    public synchronized void takeCutlery (int i) throws InterruptedException{
        while (!free)
            wait();
        System.out.println("Philosopher " + i + " takes a cutlery " + id);
        free = false;
    }

    public synchronized void dropCutlery (int i){
        free = true;
        System.out.println("Philosopher " + i + " drops the cutlery " + id);
        notify();
    }


}
