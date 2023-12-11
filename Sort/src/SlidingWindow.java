import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SlidingWindow {
    public static void maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k];
        List<Integer> arr = new ArrayList<Integer>();
        Queue<Integer> qu = new LinkedList<Integer>();
        int l = k - 1;
        qu.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (i <= l) {
                int t = qu.peek();
                while (true) {
                    if (t >= nums[i]) {
                        break;
                    }
                    qu.poll();
                    if (qu.isEmpty()) {
                        qu.add(nums[i]);
                    }
                    t = qu.peek();

                }
                qu.add(nums[i]);
            } else {
                arr.add(qu.peek());
                qu.poll();
                int t = qu.peek();

                while (true) {
                    if (t >= nums[i]) {
                        break;
                    }
                    qu.poll();
                    t = qu.peek();
                }
                qu.add(nums[i]);

            }
        }
        for (int h = 0; h < arr.size(); h++) {
            System.out.println(arr.get(h));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        maxSlidingWindow(a, k);
    }
}