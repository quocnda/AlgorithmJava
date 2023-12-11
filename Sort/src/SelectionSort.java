import java.util.Scanner;

public class SelectionSort {
    public static void selections(int a[]){
        int n = a.length;
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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n; i ++) {
            a[i] = scan.nextInt(); 
        }
        selections(a);
        for(int  i = 0 ; i < a.length ; i ++) {
            System.out.println(a[i]);
        }
    }
}
