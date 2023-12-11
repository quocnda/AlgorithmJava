package DFS;

public class ValidAVLTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;


    }
    public static boolean isBalanced(TreeNode root) {
        TreeNode right = root.right;
        TreeNode left = root.left;
        int dr  = maxDepth(right);
        int dl = maxDepth(left);
        if(Math.abs(dr-dl)>=2) {
            return false;
        }
        return true;
    }
}
