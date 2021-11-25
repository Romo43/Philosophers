public class Cutlery {
    public final int id;
    public int free = -1;

    public Cutlery(int id) {
        this.id = id;
    }

    public void takeCutlery(int i) {
        System.out.println("Philosopher " + i + " takes a cutlery " + id);
        free = i;
    }

    public void dropCutlery(int i) {
        System.out.println("Philosopher " + i + " drops the cutlery " + id);
        free = -1;
    }


}
