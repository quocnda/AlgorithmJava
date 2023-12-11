package DFS;

public class SymmetricTree101LCode {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) {
                return true;
            }
            return mirror(root.left,root.right);
        }
        public boolean mirror(TreeNode node1,TreeNode node2) {
            if(node1 == null && node2 == null) {
                return true;
            }
            if(node1 == null || node2 == null) {
                return false;
            }
            return node1.val == node2.val && mirror(node1.left,node2.right) && mirror(node1.right,node2.left);
        }
    }
}
