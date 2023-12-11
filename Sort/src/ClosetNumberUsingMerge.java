import java.util.Scanner;

public class ClosetNumberUsingMerge {
    public static void merge(int[] a,int l,int r,int m) {
        int b[] = new int[100];
        int c[] = new int[100];
        int n=0;
        int n1=0;
        for(int i = 0 ; i <=m ; i++) {
            b[i] = a[i];
            n++;
        }
        for(int j = m+1 ; j <=r; j ++) {
            c[n1] = a[j];
            n1++;
        }
        int i = 0; 
        int j = 0;
        int k = 0;
        while( i<n && j<n1) {
            if(b[i] > c[j]) {
                a[k] = c[j];
                j++;
            }
            else {
                a[k] = b[i];
                i++;
            }
            k++;
        }
        while(i<n) {
            a[k] = b[i];
            i++;
            k++;
        }
        while(j<n1) {
            a[k] = c[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] a,int l,int r) {
        int mid = (l+r)/2;
        if(l>=r) {
            return;
        }
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        merge(a, l, r, mid);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] =new int[n];
        for(int  i = 0 ; i < n; i ++) {
            a[i] =scan.nextInt();
        }
        mergeSort(a, 0, n-1);
        for(int  i = 0 ; i < n; i ++) {
            System.out.println(a[i]);
        }
    }
}
