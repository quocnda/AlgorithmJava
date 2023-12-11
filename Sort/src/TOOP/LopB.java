package TOOP;


public class LopB {
    private LopA a;
    private int tuoib;
    LopB() {
        a = new LopA();
        tuoib = 0;
    }
    public int gettuoia() {
        return a.gettuoi();
    }
    public void seta(LopA a1) {
        a = a1;
    }
    public LopA geta() {
        return a;
    }
    public void setb(int b1) {
        tuoib =b1;
    }
    public int getb() {
        return tuoib;
    }
    public static void main(String[] args) {
        LopB tmp = new LopB();
        LopA a1 = new LopA();
        a1.settuoi(100);
        tmp.seta(a1);
        System.out.println(tmp.gettuoia());
        LopA a2 = tmp.geta();
        a2.settuoi(1000000);
        System.out.println(tmp.gettuoia());
    }
}
