import java.util.Scanner;
import java.util.Stack;

public class BasicCaculatorlcode227 {
    public int calculate(String s) {
        Stack<Integer> st=new Stack();
        int num=0;
        char operator='+';

        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(Character.isDigit(ch[i]))
                num=num*10+ch[i]-'0';
            if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==ch.length-1)
            {
                if(operator=='+')
                    st.push(num);
                else if(operator=='-')
                    st.push(-num);
                else if(operator=='*')
                    st.push(st.pop()*num);
                else if(operator=='/')
                    st.push(st.pop()/num);
                num=0;
                operator=ch[i];

            }
        }

        int sum=0;
        while(!st.isEmpty())
        {
            sum+=st.pop();
        }

        return sum;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Stack<Character> st = new Stack<Character>();
        for(int  i = 0 ; i < s.length() ; i++) {
            char tmp = s.charAt(i);
            if(tmp != '+' && tmp!= '-' && tmp!='*' && tmp!='/'&&tmp!=' ' ) {
                st.push(tmp);
            } else {
                if(tmp!= ' ') {
                    if(tmp=='*') {
                        char a1 = st.peek();
                        while(true) {
                            i++;
                            tmp = s.charAt(i);
                            if(tmp != ' ') {
                                break;
                            }
                        }
                        int as1 = (int) a1 -48;
                        int tmps1 = (int) tmp-48;
                        int tich = as1*tmps1;
                        char tich1 = (char) (tich+48);
                        st.pop();
                        st.push(tich1);
                    }
                    else if (tmp == '/') {
                        char a1 = st.peek();
                        while(true) {
                            i++;
                            tmp = s.charAt(i);
                            if(tmp != ' ') {
                                break;
                            }
                        }
                        int as1 = (int) a1 -48;
                        int tmps1 = (int) tmp-48;
                        int tich = as1/tmps1;
                        char tich1 = (char) (tich+48);
                        st.pop();
                        st.push(tich1);
                    } else {
                        st.push(tmp);
                    }
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty()) {
            char pt = st.peek();
             if(pt!= '+' && pt!='-') {
                int gtri = (int) pt - 48;
                st.pop();
                if(st.isEmpty()) {
                    ans+=gtri;
                    break;
                }
                char pt2 = st.peek();
                if(pt2 == '+') {
                    ans += gtri;
                } else {
                    ans -= gtri;
                }
                st.pop();
            } else {
                int gtri = (int) pt - 48;
                ans+=gtri;
            }
        }
        System.out.println(ans);
    }
}
