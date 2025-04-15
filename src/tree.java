import java.util.*;

class main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left) {
            this.data = data;
            this.left = left;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }   // Creating Tree Node

    public static void display(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + "-->");
        if (root.left != null) System.out.print(root.left.data + " ");
        if (root.right != null) System.out.print(root.right.data + " ");
        System.out.println();

        display(root.left);
        display(root.right);
    }   // To print all Nodes via DFS

    public static int size(Node root) {
        if (root == null) return 0;

        return 1 + size(root.left) + size(root.right);
    }    // Total nodes of tree

    public static int sum(Node root) {
        if (root == null) return 0;

        return root.data + sum(root.left) + sum(root.right);
    }       // Sum of all Node values of tree

    public static int product(Node root) {
        if (root == null) return 1;
        return root.data * product(root.left) * product(root.right);
    }     // Product of all Node values of tree

    public static int maxNode(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int a = root.data;
        int b = maxNode(root.left);
        int c = maxNode(root.right);

        return Math.max(a, Math.max(b, c));
    }  // Node with maximum value

    public static int height(Node root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }   //  Height of tree

    public static void preorder(Node root) {
//        Root-->Left-->Right
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }   // Preorder traversal

    public static void inorder(Node root) {
//        Left-->Root-->Right
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }   // Inorder traversal

    public static void postorder(Node root) {
        if (root == null) return;
//        Left-->Right-->Root
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }   // Postorder traversal

    public static void nthNode(Node root, int n) {
        if (root == null) return;
        if (n == 1) System.out.print(root.data + " ");
        nthNode(root.left, n - 1);
        nthNode(root.right, n - 1);
    }     // Nth node a given tree

    public static void bfs(Node root) {
        if(root==null) return;

        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node temp=q.peek();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.data+"  ");
            q.remove();
        }
    }      // BFS using Queue

    public static void swap(Node root1,Node root2){
        int temp=root1.data;
        root1.data=root2.data;
        root2.data=temp;
    }  // Swap the TreeNode values

    public static boolean isBalanced(Node root){
        if(root==null) return true;

        int lh=height(root.left);
        if(root.left!=null) lh++;
        int rh=height(root.right);
        if(root.right!=null) rh++;
        int d=lh-rh;
        if(d<0) d=-d;
        if(d>1) return false;

        return (isBalanced(root.left)  &&  isBalanced(root.right));
    }





    public static void main(String[] args) {
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        Node c=new Node(4);
        Node d=new Node(5);
        Node e=new Node(6);
        Node f=new Node(7);
        root.left=a;
        root.right=b;
        a.left=c;
        a.right=d;
        b.left=e;
        b.right=f;
        Node temp=root;
        preorder(root);
    }
}