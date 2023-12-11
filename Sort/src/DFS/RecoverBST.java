package DFS;

import java.util.Scanner;
//chua lam duoc, ranh thi len mang xem sol
public class RecoverBST {
    // Biến lưu trữ các nút cần hoán đổi
    private TreeNode first = null;
    private TreeNode second = null;

    // Biến lưu trữ nút trước đó trong in-order traversal
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    // Hàm đệ quy thực hiện in-order traversal
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        // Kiểm tra điều kiện BST
        if (prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;
        inorderTraversal(node.right);
    }

    // Phương thức khôi phục cây
    public void recoverTree(TreeNode root) {
        // Thực hiện in-order traversal từ nút gốc
        inorderTraversal(root);

        // Hoán đổi giá trị của hai nút
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
