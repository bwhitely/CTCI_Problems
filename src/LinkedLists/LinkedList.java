package LinkedLists;

import java.util.*;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    public LinkedList(){}
    public LinkedList(Node n){ head = n; }

    void appendToTail(Node n){
        Node ref = head;

        while (ref.next != null){
            ref = ref.next;
        }
        ref.next = n;
    }

    Node deleteNode(Node head, int data){
        Node n = head;
        if (n.data == data) return head.next; // move head
        while (n.next != null){
            if (n.next.data == data){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    @Override
    public String toString(){
        Node ref = head;
        StringBuilder sb = new StringBuilder();
        while (ref.next != null){

            sb.append("Node: ").append(ref.data).append(" ");
            ref = ref.next;
        }
        sb.append("Node: ").append(ref.data);
        return sb.toString();
    }

    void rotate(){
        Node ref = head;
        Node ref2 = head.next; // one ahead
        int temp = 0;
        while (ref.next != null){
            ref.data = ref2.data;
            ref = ref.next;
            if (ref2.next == null){
                ref2 = head;
            }
            ref2 = ref2.next;
        }
        ref.data = ref2.data;
    }

    Node removeDup(int d){
        Node ref = head;
        boolean found = false;

        while (ref.next != null){
            // first sighting
            if (ref.next.data == d && !found){
                found = true;
                ref = ref.next;
            }
            // dups
            else if (ref.next.data == d && found){
                ref.next = ref.next.next;
            } // no dups
            else {
                ref = ref.next;
            }
        }
        return head;
    }

    int len(){
        int i = 0;
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
            i++;
        }
        return i+1;
    }

    void kthtolast(int k){
        Node ref = head;
        if (k >= this.len()) throw new ArrayIndexOutOfBoundsException("oob");
        int index = 0;
        while (ref.next != null){
            index++;
            ref = ref.next;
            if (this.len() - index == k){
                System.out.println(ref.data);
            }
        }
    }

    void delMiddleNode(Node node){
        if (node == head) return;
        Node ref = head;
        while (ref.next != null) ref = ref.next; // O(n)
        if (ref == node) return;
        ref = head;

        while (ref.next != null){ // O(n)
            if (ref.next.data == node.data){
                ref.next = ref.next.next;
            } else ref = ref.next;
        }
        System.out.println(this.toString());
    }

    Node partition(int d){
        Node ref = head;
        ArrayList<Integer> a = new ArrayList<>();
        // get nums
        while (ref.next != null){
            a.add(ref.data);
            ref = ref.next;
        }
        a.add(ref.data);
        Collections.sort(a);
        ref = head; // reset pointer
        Node ref2 = head;

        while (ref.next != null){
            ref.data = a.get(0);
            a.remove(0);
            ref = ref.next;
        }
        ref.data = a.get(0);
        return ref2;
    }

    Node sumList(Node n1, Node n2){
        Node ref1 = n1;
        Node ref2 = n2;
        ArrayList<Integer> integers = new ArrayList<>();
        //Node n = new Node(0);
        int carry = 0;
        int total;

        while (ref1.next != null){
            total = ref1.data + ref2.data;
            if (carry == 1){
                carry = 0;
            }
            if (total >= 10){
                carry = 1;
                integers.add(total - 10);
            }
            else integers.add(total);
            ref1 = ref1.next;
            ref2 = ref2.next;
        }
        System.out.println(integers);
        Node n = new Node(0);
        return n;
    }

    public boolean pali(LinkedList l){
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        Node ref = l.head;
        while (ref.next != null){
            integers.add(ref.data);
            s.push(ref.data);
            ref = ref.next;
        }
        integers.add(ref.data);
        s.push(ref.data);
        int i = 0;
        while (!s.isEmpty()){
            if (!Objects.equals(s.pop(), integers.get(i))){
                return false;
            }
            i++;
        }

        return true;
    }

    Node intersect(LinkedList l1, LinkedList l2){
        Node ref1 = l1.head;
        Node ref2 = l2.head;
        Node returning = null;
        while (ref1.next != null){
            while (ref2.next != null){
                if (ref1 == ref2) {
                    returning = ref1;
                    break;
                }
                ref2 = ref2.next;
            }
            ref2 = l2.head;
            ref1 = ref1.next;
        }
        return returning;
    }

    Node corrupt(LinkedList l){
        Node ref = l.head;
        HashSet<Node> hs = new HashSet<>();

        while (ref.next != null){
            if(hs.add(ref)) hs.add(ref);
            else return ref;
            ref = ref.next;
        }

        return null;
    }
}
