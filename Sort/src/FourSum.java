import java.util.Collections;
import java.util.Scanner;

public class FourSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] =new int[n];
        for(int  i = 0 ; i < n ; i ++) {
            a[i] =scan.nextInt();
        }
        for(int i = 0 ; i < n-1; i ++) {
            int minid = i;
            for(int j = i +1 ; j < n; j++ ){
                if(a[j] < a[minid]) {
                    minid = j;
                }
            }
            int tmp = a[minid];
            a[minid] = a[i];
            a[i] = tmp;
        }
        
    }
}
