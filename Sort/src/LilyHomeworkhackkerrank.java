import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LilyHomeworkhackkerrank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 0;
        int a[] = new int[n];
        int aindex[] =new int[1000];
        for(int  i = 0 ; i < n; i ++) {
            a[i] = scan.nextInt();
            aindex[a[i]] = i;
        }
        int[] b = a.clone();
        Arrays.sort(a);
        for(int i = 0 ; i < a.length ; i++) {
            if(b[i]!=a[i]) {
                ans+=1;
                int index_swap = aindex[a[i]];
                aindex[b[i]] = aindex[a[i]];
                b[i] = a[i];
                b[index_swap] = b[i];
            }
        }
        System.out.println(ans);
    }
}


