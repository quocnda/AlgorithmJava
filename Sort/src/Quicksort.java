import java.util.Scanner;

public class Quicksort{
    public static void swap(int a[],int x,int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] =tmp;
    }
    public static int patrion(int a[] , int l , int r) {
        int pivot = a[r];
        int i = l -1;
        for(int j = l ; j < r;  j ++) {
            if(a[j] <= pivot ) {
                i++;
                swap(a, i, j);
            }
        }
        i++;
        swap(a,i,r);
        for(int  j = 0 ; j < a.length; j ++) {
            System.out.print(a[j] +  " ");
        }
        return i;
    }
    public static void quicksort(int a[],int l,int r) {
        if(l >= r) {
            return;
        }
        int p = patrion(a,l,r);
        quicksort(a, l, p-1);
        quicksort(a, p+1, r);
    }
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int  i = 0 ; i < n; i ++) {
            a[i] = scan.nextInt();
        }
        quicksort(a, 0, n-1);
    }
}