import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Majoritylcode229 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < n; i ++) {
            int tmp = scan.nextInt();
            m.put(tmp,0);
            a[i] = tmp;
        }
        for(int i = 0; i < n ; i++) {
            int ch = m.get(a[i]);
            m.put(a[i], ch+1);
        }
        Set<Integer> set = m.keySet();
        for(Integer key: set) {
            System.out.println(key+"  "+m.get(key));
        } 
    }
}
