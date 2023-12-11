package DFS;

public class SameTree100LeetCode {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null) {
            return true;
        }
        if(p == null || q == null || p.val!=q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
