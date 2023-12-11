import java.util.Queue;
import java.util.Scanner;
import java.util.*;
class CompaInter implements Comparator<Integer> {
    @Override
    public int compare(Integer a,Integer b){
        int kq = a.compareTo(b);
        if(kq > 0) {
            return 1;
        }
        else if(kq<0) {
            return -1;
        }
        return 0;
    }
}
public class PriorityQueue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k= scan.nextInt();
        Queue<Integer> numbef = new java.util.PriorityQueue<Integer>();
        for(int i = 0 ; i < n; i ++) {
            int tmp =scan.nextInt();
            numbef.offer(tmp);
        }
            Iterator<Integer> it = numbef.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
        System.out.println(numbef);
        numbef.poll();
        System.out.println(numbef);
        numbef.poll();
        System.out.println(numbef);
        numbef.poll();
        System.out.println(numbef);
        numbef.poll();
        System.out.println(numbef);
    }
}
