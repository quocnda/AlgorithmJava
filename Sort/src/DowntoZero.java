import java.util.Scanner;

public class DowntoZero{
    public static boolean ngto(int a) {
        if(a < 2) {
            return false;
        }
        if(a == 2 || a ==3) {
            return true;
        }
        for(int i = 2 ; i <= Math.sqrt(a) ; i++) {
            if(a%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int ln(int a) {
        int ans = 0;
        int len = (int) Math.sqrt(a);
        for(int i = len ; i>=2 ; i--) {
            if(a%i == 0) {
                ans = a/i;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q>0) {
            int n = scan.nextInt();
            int ans = 0;
            while(true) {
                if(n==1) {
                    ans++;
                    break;
                }
                if(ngto(n)) {
                    n--;
                    ans++;
                }
                else {
                    n=ln(n);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}