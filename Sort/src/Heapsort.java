import java.util.Scanner;

public class Heapsort {
    public static void heaplify(int a[],int n, int i ) {
        int left = 2*i + 1;
        int right = 2*i+2;
        int largest = i;
        if(left < n && a[left] > a[largest]) {
            largest = left;
        }
        if(right < n && a[right] > a[largest]) {
            largest = right;
        }
        if(largest != i) {
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            heaplify(a, n, largest);
        }
    }
    public static void maxHeap(int a[]) {
        int n = a.length;
        for(int i = n/2 - 1 ; i >= 0 ; i--) {
            heaplify(a, n, i);
        }
    }
    public static void Heapsort_(int a[]) {
        maxHeap(a);
        int n = a.length;
        for(int  i = n-1; i >= 0; i--){
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            heaplify(a, i, 0);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] =new int[n];
        for(int  i = 0 ; i < n; i ++) {
            a[i] = scan.nextInt();
        }
        maxHeap(a);
        Heapsort_(a);
        for(int  i = 0 ; i < n; i ++) {
            System.out.println(a[i]);
        }
    }
}
