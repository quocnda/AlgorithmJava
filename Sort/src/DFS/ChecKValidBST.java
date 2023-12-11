package DFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class ChecKValidBST {
    private long minVal = Long.MIN_VALUE;
    //cach 1: duyet thang dung DFS
    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;

        if (minVal >= root.val)
            return false;

        minVal = root.val;

        if (!isValidBST(root.right))
            return false;

        return true;
    }
    //cach 2: dung inorder de ktra
     List<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        isValidBST(root.left);
        list.add(root.val);
        isValidBST(root.right);
        return check();
    }
    public boolean check() {
           if(list.size() == 1) return true;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
}
