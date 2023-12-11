package Graph;

import java.util.*;

public class JouneyToTheMoon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        DisjointUnionSets set  = new DisjointUnionSets(n);
        while(p> 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            set.union(a,b);
            p--;
        }
        List<List<Integer>> list = new ArrayList<>();
        int[] root = new int[n];
        for(int  i = 0 ; i < n; i ++) {
            int r = set.find(i);
            root[i]= r;
        }
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < n; i++) {
            hash.put(root[i],hash.getOrDefault(root[i],0)+1);
        }
        Set<Integer> s = hash.keySet();
        long ans = 0;
        for(Integer t : s) {
            int val = hash.get(t);
            int conlai = n-val;
            int tmp = val*conlai;
            ans+=tmp;
        }
        System.out.println(ans/2);
    }
}
