import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTreeInsertion {

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node insert(Node root, int data) {
        Node chay = root;
        Node chen = new Node(data);

        if (root == null) {
            return chen;
        }
        int gtri = chay.data;
        while (true) {
            if (gtri <= data) {
                if (chay.right == null) {
                    chay.right = chen;
                    break;
                }
                chay = chay.right;
                gtri = chay.data;
            } else {
                if (chay.left == null) {
                    chay.left = chen;
                    break;
                }
                chay = chay.left;
                gtri = chay.data;
            }
        }
        return root;
    }

    public static Node findphainhatbentrai(Node root) {
        Node chay = root.left;
        while (true) {
            if (chay.right == null) {
                break;
            }
            chay = chay.right;
        }
        return chay;
    }

    public static Node delete(Node root, int data) {
        Node chay = root;
        Node cha = null;
        boolean isLeftChild = false;

        while (chay != null && chay.data != data) {
            cha = chay;
            if (data < chay.data) {
                chay = chay.left;
                isLeftChild = true;
            } else {
                chay = chay.right;
                isLeftChild = false;
            }
        }

        if (chay == null) {
            System.out.println("Khong tim thay nut");
            return root;
        }

        // Case 1: Node to be deleted has no children
        if (chay.left == null && chay.right == null) {
            if (cha == null) {
                return null; // The tree only had one node
            } else if (isLeftChild) {
                cha.left = null;
            } else {
                cha.right = null;
            }
        }
        // Case 2: Node to be deleted has only one child
        else if (chay.left == null) {
            if (cha == null) {
                return chay.right;
            } else if (isLeftChild) {
                cha.left = chay.right;
            } else {
                cha.right = chay.right;
            }
        } else if (chay.right == null) {
            if (cha == null) {
                return chay.left;
            } else if (isLeftChild) {
                cha.left = chay.left;
            } else {
                cha.right = chay.left;
            }
        }
        // Case 3: Node to be deleted has two children
        else {
            Node successor = findphainhatbentrai(chay);
            chay.data = successor.data;
            chay.left = delete(chay.left, successor.data);
        }

        return root;
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curr = qu.remove();
            if (curr == null) {
                if (qu.isEmpty()) {
                    break;
                } else {
                    qu.add(null);
                    qu.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    qu.add(curr.left);
                }
                if (curr.right != null) {
                    qu.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
        System.out.println("");
        root = delete(root, 16);
        levelOrder(root);
    }
}
