public class Philosopher extends Thread{

    private int id;
    private Cutlery left, right;
    private Chair c;

    public Philosopher (int id, Cutlery left, Cutlery right, Chair c){
        this.id = id;
        this.left = left;
        this.right = right;
        this.c = c;
    }
    public void run (){
        while (true){
            try{
                c.takeChair(id);
                left.takeCutlery(id);
                right.takeCutlery(id);

                left.dropCutlery(id);
                right.dropCutlery(id);
                c.dropChair(id);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
