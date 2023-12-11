import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int kq = a.compareTo(b);
        if (kq > 0) {
            return -1;
        }
        else if (kq < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
public class KthLargesr{
    
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> qu = new PriorityQueue<Integer>(new CustomComparator());
        
        for(int i = 0 ; i < n; i ++) {
            qu.offer(nums[i]);
        }
        while(k!=1) {
            qu.poll();
            k--;
        }
        int ans = qu.peek();
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = scan.nextInt();
        }
        int ans = findKthLargest(a, k);
        System.out.println(ans);
    }
}
