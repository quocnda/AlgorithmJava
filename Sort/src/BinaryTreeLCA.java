import java.util.*;

class NodeInTreeLCA {
    Node1 left;
    Node1 right;
    int data;
    
    NodeInTreeLCA(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeLCA {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
   public static boolean checkBST(Node1 root) {
        int data = root.data;
        if(root.left == null) {
            return true;
        }
        int datal = root.left.data;
        if(datal > data) {
            return false;
        }
        if(root.right == null) {
            return true;
        }
        int datar = root.right.data;
        if(datar < data) {
            return false;
        }
        checkBST(root.left);
        checkBST(root.right);
        return true;
}
	public static Node1 lca(Node1 root, int v1, int v2) {
      	// Write your code here.
          if(root == null ) {
            return null;
          }
          if(v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
          } else if (v1 < root.data && v2< root.data) {
            return lca(root.left, v1, v2);
          } else {
            return root;
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
        int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node1 ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}