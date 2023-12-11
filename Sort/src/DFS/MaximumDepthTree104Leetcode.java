package DFS;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//}
public class MaximumDepthTree104Leetcode {
    public static int ans = 0;
    public static int dem = 0;
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;


    }
    public static void insertNodeLeft(TreeNode p,TreeNode ch) {
        p.left = ch;
    }
    public static void insertNodeRight(TreeNode p, TreeNode ch) {
        p.right= ch;
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);

//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(9);
//        TreeNode c = new TreeNode(20);
//        TreeNode d = new TreeNode(15);
//        TreeNode e = new TreeNode(7);
//        insertNodeRight(c,e);
//        insertNodeLeft(c,d);
//        insertNodeRight(a,c);
//        insertNodeLeft(a,b);
        System.out.println(maxDepth(a));
    }
}
