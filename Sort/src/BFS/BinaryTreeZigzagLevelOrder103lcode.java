package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrder103lcode {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> t = new ArrayList<>();
        dlevelOrder(root,0,t);
        List<List<Integer>> ans = new ArrayList<>();
        for(int  i = 0 ; i < t.size() ; i ++) {
            List<Integer> tmp  = t.get(i);
            if(i%2==1) {
                Collections.reverse(tmp);
            }
            ans.add(tmp);
        }
        return ans;
    }
    public void dlevelOrder(TreeNode root,int l,List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        if(ans.size() == l){
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            ans.add(t);
        } else {
            ans.get(l).add(root.val);
        }
        dlevelOrder(root.left,l+1,ans);
        dlevelOrder(root.right,l+1,ans);
    }
}
