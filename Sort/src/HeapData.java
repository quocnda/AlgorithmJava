import java.util.Scanner;

public class HeapData {
    public static int heap[];
    public static int size;
    HeapData() {
        heap =new int[100000];
        size= -1;
    }
    public static int getParent(int childindex) {
        return (childindex-1)/2;
    }
    public static int getLeftChild(int parentIndex) {
        return parentIndex*2+1;
    }
    public static int getRightChild(int parentIndex) {
        return parentIndex*2+2;
    }
    public static boolean hasParent(int childindex) {
        int parent = (childindex - 1)/2;
        if(parent > 0) {
            return true;
        }
        return false;
    }
    public static boolean hasLeftChild(int parentIndex) {
        int leftch = parentIndex*2+1;
        if(leftch > size) {
            return false;
        }
        return true;
    }
    public static boolean hasRigthChild(int parentIndex) {
        int rightL = parentIndex*2+2;
        if(rightL > size) {
            return false;
        }
        return true;
    }
    public static void add(int v) {
        size++;
        heap[size] = v;
        heaplifyUp();
    }
    public static void remove(int v) {
        int i = 0 ;
        while(i<size) {
            if(heap[i] == v) {
                break;
            }
            i++;
        }
        heap[i] = heap[size];
        size--;
        heaplifyDown(i);
    }
    public static int getMin() {
        return heap[0];
    }
    public static void swap(int i,int j) {
        int temp = heap[i];
        heap[i] =heap[j];
        heap[j] = temp;
    }
    public static void heaplifyUp() {
        int parent = getParent(size);
        int child = size;
        while(heap[parent] > heap[child]) {
            swap(parent, child);
            child = parent;
            parent = getParent(parent);
        }
    }
    public static void heaplifyDown(int i) {
        while(hasLeftChild(i)) {
            int left = getLeftChild(i);
            int min = left;
            if(hasRigthChild(i)) {
                int right = getRightChild(i);
                if(heap[left] < heap[right]) {
                    min = left;
                }
                else {
                    min = right;
                }
            }
            if(heap[i] < heap[min]) {
                break;
            }
            swap(i, min);
            i = min;
        }
     }
     public static int[] heapsortmintomax() {
        System.out.println(" da vao day");
        int ans[] =new int[size+1];
        for(int i = 0 ; i <= size ; i++){
            int tmp = getMin();
            ans[i] = tmp;
            remove(tmp);
        }
        return ans;
     }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HeapData heap = new HeapData();
        for(int i = 0 ; i < n; i ++) {
            int v =scan.nextInt();
            heap.add(v);
        }
        int man[] = heap.heap;
        for(int i = 0 ; i < n; i ++) {
            System.out.println(man[i]);
        }
        int ans[] = heap.heapsortmintomax();
        for(int i = 0 ; i < ans.length ; i ++) {
            System.out.println(ans[i]);
        }
    }
}
