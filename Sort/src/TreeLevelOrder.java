import java.util.*;

class NodeInLevelOrder {
    Node1 left;
    Node1 right;
    int data;
    
    NodeInLevelOrder(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution1 {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node1 root) {
      if(root == null) {
          return;
      }
      Queue<Node1> qu = new LinkedList<>();
      qu.add(root);
      while(!qu.isEmpty()) {
          Node1 curr = qu.remove();
          if(curr == null) {
              if(qu.isEmpty()) {
                  break;
              }
              else {
                  qu.add(null);
                  qu.add(null);
              }
          }
           else {
               System.out.print(curr.data+ " ");
               if(curr.left!=null) {
                   qu.add(curr.left);
               }
               if(curr.right!=null) {
                   qu.add(curr.right);
               }
           }
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
        levelOrder(root);
    }	
}