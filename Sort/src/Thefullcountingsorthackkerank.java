import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thefullcountingsorthackkerank {
    public static void countSort(List<List<String>> arr) {
        // Write your code here
            String[] ans = new String[1000];
            for(int  i = 0 ; i < 1000 ;i ++) {
                ans[i] ="";
            }
            int n = arr.size();
            for(int i = 0 ; i < arr.size() ; i ++) {
                List<String> tmp  = arr.get(i);
                String stt = tmp.get(0);
                String ttin = tmp.get(1);
                int st = Integer.parseInt(stt);
                String a = ans[st];
                if(i<n/2) {
                    a+="- ";
                } else {
                    a+=ttin;
                    a+=" ";
                }
                ans[st] = a;
            }
            for(int  i = 0 ; i < 1000 ; i ++) {
                String a = ans[i];
                if(a == "") {
                    continue;
                }
                System.out.print(a);
            }
        }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<String>> li = new ArrayList<>();
        for(int  i = 0 ; i < n; i ++) {
            List<String> t = new ArrayList<>();
            String s1 = scan.next();
            String s2 = scan.next();
            t.add(s1);
            t.add(s2);
            li.add(t);
        }
        for(int  i = 0 ; i < n; i ++) {
            List<String> t = li.get(i);
            for(int j = 0 ; j < t.size() ; j++){
                String tm = t.get(j);
                System.out.print(tm+" ");
            }
            System.out.print("\n");
        }
    }
}
