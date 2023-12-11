package DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSum2Lcode113 {
    public void pathsm(TreeNode root,int target,List<List<Integer>> res,List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if(root.val==target && root.right==null && root.left==null ) {
            res.add(new ArrayList<>(temp));
        }
        pathsm(root.left,target-root.val,res,temp);
        pathsm(root.right,target-root.val,res,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        pathsm(root,targetSum,res,temp);
        return res;
    }
}
