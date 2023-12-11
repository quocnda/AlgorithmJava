import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import javax.swing.RowFilter.Entry;
class info{
    public char a;
    public int n;
    info(char a1,int n1) {
        a=a1;
        n=n1;
    }
    public String getinfo() {
        return n+" "+a;
    }
}
public class SortCharacterlcode451 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Map<Character,Integer> m1 =new HashMap<Character,Integer>();
        for(int  i = 0 ; i < s.length() ; i++) {
            char tmp = s.charAt(i);
            m1.put(tmp, m1.getOrDefault(tmp, 0) + 1);
        }
        ArrayList<info> tmp = new ArrayList<info>();
        Set<Character> setk = m1.keySet();
        for(Character setk1 : setk) {
            int solan = m1.get(setk1);
            info temp1 = new info(setk1, solan);
            tmp.add(temp1);
        }
        Comparator<info> information = new Comparator<info>() {
            @Override
            public int compare(info a,info b) {
                int a1 = a.n;
                int b1 = b.n;
                return b1-a1;
            }
        };
        Collections.sort(tmp,information);
        String ans = "";
        for(int  i = 0 ; i <tmp.size() ; i++) {
            info at = tmp.get(i);
            int slan = at.n;
            char ktu = at.a;
            for(int j = 0 ; j<slan ; j ++) {
                ans+=ktu;
            }
        }
        
    }
}
