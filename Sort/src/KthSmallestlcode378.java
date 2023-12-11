import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthSmallestlcode378 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         Queue<Integer> qu = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int n= scan.nextInt();
        int a[] =new int[n];
        for(int i = 0 ; i < n; i ++) {
            a[i] =scan.nextInt();
            qu.add(a[i]);

        }
        while (!qu.isEmpty()) {
            int t = qu.poll();
            System.out.println(t);
        }
        
        
    }
}
