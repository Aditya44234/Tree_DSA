import java.util.*;

class tree {
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

    public static boolean isSameTree(Node a,Node b){
        if(a==null && b==null) return true;

        if(a.data!=b.data) return false;

        return (isSameTree(a.left,b.left)  && isSameTree(a.right,b.right));
    }

    public static void helper(Node root,List<String>  ans,String str){
        if(root==null) return;

        if(root.left==null && root.right==null){
            str+=root.data;
            ans.add(str);
            return;
        }

        helper(root.left,ans,str+root.data+"-->");
        helper(root.right,ans,str+root.data+"-->");

    }

    public static List<String> treePath(Node root){
        List<String> ans=new ArrayList<>();

        helper(root,ans,"");

        return ans;
    }







    public static void main(String[] args) {
        Node root1=new Node(1);
        Node a1=new Node(2);
        Node b1=new Node(3);
        Node c1=new Node(4);
        Node d1=new Node(5);

        root1.left=a1;
        root1.right=b1;
        a1.left=c1;
        a1.right=d1;

        Node root2=new Node(1);
        Node a2=new Node(2);
        Node b2=new Node(3);

        root2.left=a2;
        root2.right=b2;

       preorder(root1);
        System.out.println();

        System.out.println(treePath(root1));

        System.out.println("Hello World");










    }
}