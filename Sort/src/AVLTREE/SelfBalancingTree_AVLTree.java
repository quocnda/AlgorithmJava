package AVLTREE;
import java.util.Scanner;


class Node {
    Node left;
    Node right;
    int data;
    int ht;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        ht = 0;
    }
}
public class SelfBalancingTree_AVLTree {
    static int getHeight(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    static int balanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    static Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    static Node balance(Node root) {
        if (Math.abs(balanceFactor(root)) <= 1) return root;
        else if (balanceFactor(root) > 1) { //left
            if (balanceFactor(root.left) < 0) { //left right
                root.left = rotateLeft(root.left);
            }
						//left left
            root = rotateRight(root);
        } else {
            if (balanceFactor(root.right) > 0) {    //right left
                root.right = rotateRight(root.right);
            }
						//right right
            root = rotateLeft(root);
        }
        return root;
    }

	static Node insert(Node root,int data)
    {
    	if (root == null) {
            Node node = new Node(data);
            node.data = data;
            node.ht = 0;
            node.left = null;
            node.right = null;
            return node;
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            return root;
        }
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return balance(root);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root = insert(root, 1);
        root = insert(root, 9);
        root = insert(root, 7);
        root = insert(root,10);
        root = insert(root,8);
    }
}
