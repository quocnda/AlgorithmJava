import java.util.*;

class NodeInTreeInOrder {
    Node1 left;
    Node1 right;
    int data;
    
    NodeInTreeInOrder(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Node1 root) {
        if(root == null) {
            return;
        }
        Node1 right = root.right;
        Node1 left  = root.left;
        if(left != null) {
        inOrder(left);
        }
        System.out.print(root.data + " ");
        if(right!= null) {
            inOrder(right);
        }
        
    }

	public static Node1 insert(Node1 root, int data) {
        if(root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }	
}