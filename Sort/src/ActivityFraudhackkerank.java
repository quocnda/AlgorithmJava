//bai ni hay, nen xem lai

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ActivityFraudhackkerank {
    public static int getmedian(int[] countingsort,int d) {
        int m1 = -1;
        int m2 = -1;
        int c1 = d/2;
        int c2 = d/2+1;
        int counter = 0;
        for(int  i = 0 ; i < countingsort.length ; i++) {
            counter += countingsort[i];
            if(counter >= c1 && m1 == -1) {
                m1 = i;
            } 
            if(counter>=c2 && m2 == -1) {
                m2 = i;
                break;
            }
        }
        if(d%2==1) {
            return 2*m2;
        }
        return m1+m2;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int expendi[] = new int[201];
        for(int i = 0 ; i < 201 ; i++) {
            expendi[i] = 0;
        }
        for(int  j = 0 ; j < d ; j++) {
            expendi[a[j]]++;
        }
        int ans = 0;
        for(int j = d; j < n;j++) {
            int t = a[j];
            int med = getmedian(expendi, d);
            if(t>=med) {
                ans++;
            }
            expendi[a[j-d]]--;
            expendi[a[j]]++;
        }
        System.out.println(ans);
    }
}
