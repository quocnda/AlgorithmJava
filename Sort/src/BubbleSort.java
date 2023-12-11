import java.util.Scanner;

public class BubbleSort {
    public static void Bubble(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for(int j = 1;j<=n-i;j++) {
                if(a[j] <a[j-1] ) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    public static void InsertionSort(int[] a,int n) {
        for(int i = 1; i< n;i++) {
            if(a[i] < a[i-1]) {
                int  j = 0;
                int tmp = a[i];
                while(j<=i) {
                    if(a[j] > a[i]) {
                        break;
                    }
                    j++;
                }
                for(int h = i ;h>=j+1;h--) {
                    a[h] = a[h - 1];
                }
                a[j] = tmp;
            }   
        }
    }
    public static void QuickSort(int[] a,int n) {
        int cnt= 0;
        for(int  i = 0 ; i<n;i++) {
            if(a[i] < a[i+1]) {
                cnt++;
            }
        }
        if(cnt == n-1) {
            for(int  i = 0 ; i<n;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
            return;
        }
        int[] left = new int[100];
        int[] right = new int[100];
        int csr = 0;
        int csl = 0;
        int piv = a[0];
        for(int  i = 1; i < n;i++) {
            int tmp = a[i];
            if(tmp>piv) {
                right[csr] = tmp;
                csr++;
            }
            else {
                left[csl] = tmp;
                csl++;
            }
        }
        QuickSort(left,csl);
        QuickSort(right, csr);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[100];
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        QuickSort(a, n);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}