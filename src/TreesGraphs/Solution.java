package TreesGraphs;

public class Solution {
    public static void main(String[] args) {
        Tree t = new Tree();

        Heap h = new Heap(new Node(4));
        h.root.left = new Node(50);
        h.root.left.left = new Node(55);
        h.root.left.right = new Node(90);
        h.root.right = new Node(7);
        h.root.right.left = new Node(87);


    }
}
