package StacksQueues;

import java.util.EmptyStackException;

public class SortableStack {
    private static class MyStackNode {
        private int data;
        private MyStackNode next;

        public MyStackNode(int data) { this.data = data; }
    }

    private MyStackNode top;
    private int size;
    private Integer min;

    public int pop(){
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(int item){
        MyStackNode t = new MyStackNode(item);
        t.next = top;
        top = t;
        size++;
    }

    public int peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){ return size; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        MyStackNode ref = top;
        while (ref.next != null){
            sb.append(ref.data).append(" ");
            ref = ref.next;
        }
        sb.append(ref.data).append(" ");
        return sb.toString();
    }

    public void sort(){
        SortableStack t = new SortableStack();
        while (!this.isEmpty()){
            int temp = this.pop();
            while (!t.isEmpty() && t.peek() > temp){
                this.push(t.pop());
            }
            t.push(temp);
        }
        while (!t.isEmpty()){
            this.push(t.pop());
        }
    }
}

