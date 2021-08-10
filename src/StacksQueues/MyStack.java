package StacksQueues;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class MyStackNode<T> {
        private T data;
        private MyStackNode<T> next;

        public MyStackNode(T data){
            this.data = data;
        }
    }

    private MyStackNode<T> top;
    private int size;
    private T min;

    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item){
        MyStackNode<T> t = new MyStackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek(){
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
        MyStackNode<T> ref = top;
        while (ref.next != null){
            sb.append(ref.data).append(" ");
            ref = ref.next;
        }
        sb.append(ref.data).append(" ");
        return sb.toString();
    }
}
