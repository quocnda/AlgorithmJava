package BFS;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        val = 0;
        left = null;
        right = null;
    }
    TreeNode(int val,TreeNode right,TreeNode left) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class BinaryTreeOrderLevel102lcode {
    public List<List<Integer>> l = new ArrayList<>();
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> t = new ArrayList<>();
            dlevelOrder(root,0,t);
            return t;
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
}
