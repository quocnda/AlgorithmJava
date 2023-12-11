import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> m = new HashMap<>();
        int n = scan.nextInt();
        for(int  i = 0 ; i < n; i ++ ) {
            String name = scan.nextLine();
            String phone = scan.nextLine();
            m.put(name,phone);
        }
        for(int  i = 0 ; i < n; i++) {
            String namecheck = scan.nextLine();
            if(m.get(namecheck) != "") {
                String num  = m.get(namecheck);
                System.out.println(namecheck + "="  + num);
            } else {
                System.out.println("Not Found");
            }
        }
    }
}
