package StacksQueues;

public class QueueAsStacks<T> {
    private static class QueueAsStacksNode<T>{
        public T data;
        private QueueAsStacksNode<T> next;

        public QueueAsStacksNode(T data){
            this.data = data;
        }

        public T data() { return data; }

        @Override
        public String toString() { return data.toString(); }
    }
    private MyStack<QueueAsStacksNode<T>> stack1;
    private MyStack<QueueAsStacksNode<T>> stack2;

    public QueueAsStacks(){stack1 = new MyStack<>();stack2 = new MyStack<>();}

    public QueueAsStacksNode<T> remove(){
        shift();
        QueueAsStacksNode<T> temp = stack2.pop();
        shift();
        return temp;
    }

    public void add(T item){
        QueueAsStacksNode<T> t = new QueueAsStacksNode<>(item);
        stack1.push(t);
    }

    public void shift(){
        if (!stack1.isEmpty() && stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        else {
            while (!stack2.isEmpty()) stack1.push(stack2.pop());
        }
    }

    public QueueAsStacksNode<T> peek(){
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        while (isEmpty()){
            sb.append(remove().data).append("\n");
        }
        return sb.toString();
    }
}
