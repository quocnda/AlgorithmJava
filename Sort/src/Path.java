import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Path {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        String ans = "";
        List<String> str = new ArrayList<String>();
        List<String> strans = new ArrayList<String>();
        Stack<String> st = new Stack<String>();
        if(path.charAt(path.length() -1) != '/'){
            path+="/";
        }
        for(int i = 0 ; i < path.length() ; i++) {
           if(path.charAt(i) == '/') {
            continue;
           }
           else {
             String tmp = "";
             while(true) {
                char t = path.charAt(i);
                tmp+=t;
                i++;
                if(path.charAt(i) == '/') {
                    i--;
                    str.add(tmp);
                    break;
                }
             }
           }
        }
        for(int i = 0 ; i < str.size(); i++) {
            String tmp = str.get(i);
            if(!tmp.equals("..")) {
                if(!tmp.equals("."))
                 {
                    st.add(tmp);
                 }
            } else {
                if(!st.empty()) {
                    st.pop();
                }
            }
        }
        while(!st.empty()) {
            String t =st.peek();
            strans.add(t);
            st.pop();
        }
        for(int i = strans.size() -1 ; i >=0 ;i--){
            String t = strans.get(i);
            ans+='/';
            ans+=t;
        }
        if(ans.equals("")) {
            ans="/";
        }
        System.out.println(ans);
    }
}
