import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JumpGameII {
    public static int jump(int[] nums){
        int n = nums.length;
        int[] a = new int[n];
        for(int i = 0 ; i < n; i ++) {
            a[i] = 0;
        }
        a[0] = 0;
        for(int i = 0 ; i < n;i++) {
           int sobuoc = nums[i];
            for(int j = 1 ; j<= sobuoc ; j++){
                if(i+j >= n) {
                    break;
                }
                if(a[i+j] == 0) {
                    a[i+j] = a[i] +1;
                } else {
                    int then = a[i+j];
                    int tmp = a[i] +1;
                    if(then > tmp){
                        a[i+j] = tmp;
                    }
                }
            }
        }
        System.out.println(n-1);
        return a[4];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[100];
        for(int i = 0 ; i < n ; i ++) {
            a[i] = scan.nextInt();
        }
        int ans = jump(a);
        System.out.println(ans);
    }
}