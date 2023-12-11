class Node1 {
    public Node1 left;
    public Node1 right;
    public int data;
    public int ht;
    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
        ht = 0;
    }
}
public class AVLTree {
    public static Node1 rotateRightRight(Node1 r) {
        Node1 right1 = r.right;
        Node1 left2 = right1.left;
        Node1 right2 = right1.right;
        r.right = left2;
        right1.left = r;
        r = right1;
        return right1;
    }
	public static Node1 insert(Node1 root, int data) {
        Node1 chay = root;
        Node1 chen = new Node1(data);
       
        if(root == null) {
            return chen;
        }
         int gtri = chay.data;
        while(true) {
            if(gtri <= data) {
                if(chay.right == null) {
                    chay.right = chen;
                    break;
                }
                chay = chay.right;
                gtri = chay.data;
            }
            else {
                 if(chay.left == null) {
                    chay.left = chen;
                    break;
                }
                chay = chay.left;
                gtri = chay.data;
            }
        }
        return root;
    }
    public static Node1 rotateRightLeft(Node1 r) {
        Node1 right1 = r.right;
        Node1 left2  = right1.left;
        Node1 right3 = left2.right;
        right1.left = right3;
        left2.right = right1;
        r.right = left2;
        r = rotateRightRight(r);
        return r;
    }
    public static Node1 rotateLeftLeft(Node1 r) {
        Node1 left1 = r.left;
        Node1 right2 = left1.right;
        Node1 left2 = left1.left;
        r.left = right2;
        left1.right = r;
        r = left1;
        return left1;
    }
    public static Node1 rotateLeftRight(Node1 r) {
        Node1 left1 = r.left;
        Node1 right2  = left1.right;
        Node1 left3 = right2.left;
        left1.right = left3;
        right2.left = left1;
        r.left = right2;
        r = rotateRightRight(r);
        return r;
    }
    public static void main(String[] args) {
        Node1 root = new Node1(3);
        System.out.println(root.data);
        // Node root = null;
        // Scanner scan = new Scanner(System.in);
        // int n  =scan.nextInt();
        // for(int  i = 0 ; i < n;  i++) {
        //     int tmp  = scan.nextInt();
        //    root =  insert(root, tmp);
        // }
        // root = rotateRightLeft(root);
        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);
        // System.out.println(root.right.right.data);
        // System.out.println(root.right.left.data);
        
    }
}
