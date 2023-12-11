import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> st;
    public Stack() {
        st= new ArrayList<Integer>();
    }
    
    public void push(int x) {
        st.add(x);
    }
    
    public int pop() {
        int si = st.size();
        int t = st.get(si-1);
        st.remove(si-1);
        return t;
    }
    
    public int top() {
        int si = st.size();
        int t = st.get(si-1);
        return t;
    }
    
    public boolean empty() {
        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
}
