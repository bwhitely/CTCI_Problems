package StacksQueues;

public class SetOfStacks {
    private MyStack<Integer> top;
    private MyStack<MyStack<Integer>> stacks;

    public SetOfStacks(){
        this.stacks = new MyStack<>();
        this.top = new MyStack<>();
    }

    public void push(Integer data){
        if (top.size() >= 5) newStack();
        else if (stacks.isEmpty()){
            stacks.push(new MyStack<>());
        }
        top.push(data);
    }

    public Integer pop(){
        if (top.isEmpty()){
            stacks.pop();
        }

        return top.pop();
    }

    public void newStack(){
        MyStack<Integer> s = new MyStack<>();
        stacks.push(s);
        top = s;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
