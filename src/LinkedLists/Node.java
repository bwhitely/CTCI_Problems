package LinkedLists;

public class Node {
    Node next = null;
    int data;

    public Node(int d){
        data = d;
    }

    int getData() { return data; }
    void setData(int d) { data = d;}
}
