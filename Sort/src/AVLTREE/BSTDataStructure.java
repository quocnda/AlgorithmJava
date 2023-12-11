package AVLTREE;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;
    BSTNode(int a) {
        this.data = a;
        left = null;
        right = null;
    }
    BSTNode(int a,BSTNode l,BSTNode r) {
        left = l;
        data =a ;
        right = r;

    }
}
public class BSTDataStructure {
    public static void preOrder(BSTNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void hauOrder(BSTNode root) {
        if(root == null ) {
            return;
        }
        hauOrder(root.left);
        hauOrder(root.right);
        System.out.println(root.data);
    }
    public static void inOrder(BSTNode root) {
        if(root == null) {
            return;
        }
        BSTNode right = root.right;
        BSTNode left  = root.left;
        if(left != null) {
            inOrder(left);
        }
        System.out.print(root.data + " ");
        if(right!= null) {
            inOrder(right);
        }
    }
    public static BSTNode findphaibentrai(BSTNode root) {
        BSTNode chay = root.left;
        while(true) {
            if(chay.right == null) {
                break;
            }
            chay = chay.right;
        }
        return chay;
    }
    public static BSTNode deleteNode(BSTNode root,int data) {
        BSTNode chay = root;
        BSTNode cha = null;
        boolean isLeftChild = false;
        while(chay!=null && chay.data != data) {
            cha = chay;
            if(data < chay.data) {
                chay = chay.left;
                isLeftChild = true;
            } else {
                chay = chay.right;
                isLeftChild = false;
            }
        }
        if(chay == null) {
            System.out.println("khong tim thay node phu hop");
            return null;
        }
        // case1: Node to  be deleted has no children
        if(chay.right == null && chay.left == null) {
            if(cha == null) {
                return null;
            }
            else {
                if (isLeftChild) {
                    cha.left = null;
                }
                else {
                    cha.right = null;
                }
            }
        }
        //case 2: Node to be deleted has one children
        else if (chay.left == null) {
            if(cha == null) {
                return chay.right;
            }
            else {
                if(isLeftChild) {
                    cha.left = chay.right;
                } else {
                    cha.right = chay.right;
                }
            }
        } else if(chay.right == null) {
            if(cha == null) {
                return chay.left;
            } else {
                if(isLeftChild) {
                    cha.left = chay.left;
                }
                else {
                    cha.right = chay.left;
                }
            }
        }
        // case 3: Node to be deleted has 2 childrens
        else {
            BSTNode temp = findphaibentrai(root);
            chay.data = temp.data;
            chay.left = deleteNode(chay.left,temp.data);
        }
        return root;
    }
    public static BSTNode insertNode(BSTNode root,int data) {
        BSTNode run = root;
        BSTNode temp = new BSTNode(data);
        if(run == null) {
             return temp;
        }

        while(true) {
            int datar = run.data;
            if (data < datar) {
                if (run.left == null) {
                    run.left = temp;
                    break;
                }
                run = run.left;
            } else {
                if (run.right == null) {
                    run.right = temp;
                    break;
                }
                run  = run.right;
            }
        }
        return root;
    }

    public static BSTNode insertNodeUsingDeQuy(BSTNode root,int data) {
        if(root == null) {
            BSTNode temp = new BSTNode(data);
            root = temp;
            return root;
        }
        int datar = root.data;
        if(datar < data) {
            if(root.right == null) {
                root.right = new BSTNode(data);
            } else {
                insertNodeUsingDeQuy(root.right,data);
            }
        }
        else {
            if(root.left == null) {
                root.left = new BSTNode(data);
            }
            else {
                insertNodeUsingDeQuy(root.left,data);
            }
        }
        return root;
    }

    public static void levelOrder(BSTNode root) {
        if(root == null) {
            return;
        }
        Queue<BSTNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()) {
            BSTNode cur = qu.remove();
            if(cur == null) {
                if(qu.isEmpty()) {
                    break;
                } else {
                    qu.add(null);
                    qu.add(null);
                }
            } else {
                System.out.println(cur.data +" ");
                if(cur.left != null) {
                    qu.add(cur.left);
                }
                if(cur.right != null) {
                    qu.add(cur.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BSTNode root = null;
        int n = scan.nextInt();
        while(n>0) {
            int t = scan.nextInt();
            root = insertNode(root,t);
            n--;
        }
        hauOrder(root);
        int socansoa = scan.nextInt();
        root = deleteNode(root,socansoa);
        levelOrder(root);
    }
}


