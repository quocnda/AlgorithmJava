import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopKFrequentEle {
    public static int[] topkfre(int[] nums,int k) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for(int key  : freq.keySet()) {
            int frequency = freq.get(key);
            if(frequency >= k) {
                ans.add(key);
            }
            System.out.print(key+"  "+frequency);
        }
        int len = ans.size();
        int i = 0 ;
        int a[]= new int[len];
        for(int j = 0; j < len;j++) {
            int tmp = ans.get(j);
            a[i] = tmp;
            i++;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0; i< n; i++) {
            a[i] = scan.nextInt();
        }
        topkfre(a,1);
    }
}
