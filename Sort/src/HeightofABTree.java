import java.util.*;

class NodeInHeightABTree {
    Node1 left;
    Node1 right;
    int data;

    NodeInHeightABTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightofABTree {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int ans = 0;
    public static int maxans = 0;

    public static int height(Node1 root) {
        // Write your code here.
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node1 root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}