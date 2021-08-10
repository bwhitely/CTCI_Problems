package TreesGraphs;

public class Heap {
    Node root;

    public Heap(Node root){
        this.root = root;
    }

    public void insert(Node root) {
        Node ref = recurRight(this.root); // get right most node
        ref.right = root; // place node - 2 (parameter)
        Node temp;

        while (root.data < ref.data){ // swap elements if parameter less than parent
            temp = ref; // 7
            root.left = ref.left; // set new node left
            root.right = temp; // set new node right
            temp.right = null; // old node right
            temp.left = null; // old node left
        }
    }

    public Node extract_min(){
        return null;
    }

    public Node recurRight(Node root){
        if (root == null) return null;
        if (root.right == null) return root;

        return recurRight(root.right);
    }

    public void recRight(Node root){
        if (root != null){
            System.out.println(root.data);
            recRight(root.right);
        }
    }
}
