public class Bird  extends Animal{
    public void run() {
        System.out.println("Bird is runningg ... ");
    }
    public void chac() {
        System.out.println("check out the animal");
    }
    public static void main(String[] args) {
        Animal a = new Bird();
        a.run();
    }
}
