import java.util.*;
import java.util.PriorityQueue;

public class Baichiquentenroi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Queue maxpq = new PriorityQueue(n / 2 + 1, Collections.reverseOrder());
        Queue minpq = new PriorityQueue<>(n / 2 + 1);
        int cnt = 1;
        int med = 0;
        while (cnt <= n) {
            boolean dain = false;
            int tmp = scan.nextInt();
            if (cnt == 1) {
                maxpq.offer(tmp);
                med = tmp;
                System.out.printf("%.1f\n", (double) tmp);
                cnt++;
            } else {
                int lenmax = maxpq.size();
                int lenmin = minpq.size();
                if(lenmax > lenmin) {
                    int pe = (Integer) maxpq.peek();
                    if(tmp < pe) {
                        maxpq.poll();
                        minpq.offer(pe);
                        maxpq.offer(tmp);
                    } else if (tmp>=pe) {
                        minpq.offer(tmp);
                    }
                } else if (lenmax == lenmin) {
                    int map = (Integer) maxpq.peek();
                    int mip = (Integer) minpq.peek();
                    if(map >= tmp) {
                         System.out.printf("%.1f\n", (double) map);
                         dain = true;
                        maxpq.offer(tmp);
                    }
                    else if(map < tmp && tmp < mip) {
                         System.out.printf("%.1f\n", (double) tmp);
                         dain = true;
                         maxpq.offer(tmp);
                    } else {
                         System.out.printf("%.1f\n", (double) mip);
                         dain = true;
                         minpq.offer(tmp);
                    }
                } else {
                    int pe = (Integer) minpq.peek();
                    if(tmp < pe) {
                        maxpq.offer(tmp);
                    } else {
                        minpq.poll();
                        minpq.offer(tmp);
                        maxpq.offer(pe);
                    }
                }
                if(!dain) {
                    int a = (Integer) maxpq.peek();
                    int b = (Integer) minpq.peek();
                    double ans = (a+b)/2;
                     System.out.printf("%.1f\n", (double) ans);
                }
                cnt++;
            }

        }
    }
}