package StacksQueues;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class MyQueueNode<T>{
        private T data;
        private MyQueueNode<T> next;

        public MyQueueNode(T data){
            this.data = data;
        }
    }

    private MyQueueNode<T> first;
    private MyQueueNode<T> last;

    public void add(T item){
        MyQueueNode<T> t = new MyQueueNode<>(item);
        if (last != null) last.next = t;
        last = t;
        if (first == null) first = last;
    }

    public T remove(){
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        return data;
    }

    public T peek(){
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        T temp;
        while (!this.isEmpty()){
            temp = this.remove();
            sb.append(temp).append("\n");
        }
        return sb.toString();
    }
}
