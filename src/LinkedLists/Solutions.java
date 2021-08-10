package LinkedLists;

public class Solutions {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(new Node(7));
        l1.appendToTail(new Node(1));
        l1.appendToTail(new Node(6));
        LinkedList l2 = new LinkedList(new Node(5));
        l2.appendToTail(new Node(9));
        l2.appendToTail(new Node(2));
        l1.sumList(l1.head,l2.head);

        LinkedList l3 = new LinkedList(new Node(7));
        l3.appendToTail(new Node(1));
        l3.appendToTail(new Node(6));
        l3.appendToTail(new Node(1));
        l3.appendToTail(new Node(7));
        System.out.println(l3.pali(l3));

        LinkedList l4 = new LinkedList(new Node(7));
        LinkedList l5 = new LinkedList(new Node(1));
        Node nn = new Node(3);

        l4.appendToTail(new Node(2));
        l4.appendToTail(new Node(9));
        l4.appendToTail(new Node(111));
        l5.appendToTail(new Node(234));
        l5.appendToTail(nn);
        l4.appendToTail(nn);
        l5.appendToTail(new Node(32));
        l5.appendToTail(new Node(7));
        System.out.println(l4.intersect(l4,l5).data);

        Node loop = new Node(3);
        LinkedList l6 = new LinkedList(new Node(1));
        l6.appendToTail(new Node(2));
        l6.appendToTail(loop);
        l6.appendToTail(new Node(4));
        l6.appendToTail(new Node(5));
        l6.appendToTail(loop);
        System.out.println(l6.corrupt(l6).data);
    }
}
