package TreesGraphs;

public class Tree {
    public Node root;

    void inOrderTraversal(Node root){
        if (root != null){
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    void preOrderTraversal(Node root){
        if (root != null){
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(Node root){
        if (root != null){
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }
}
