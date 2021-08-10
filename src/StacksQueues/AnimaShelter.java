package StacksQueues;

import java.util.LinkedList;

public class AnimaShelter {
    LinkedList<String> cats;
    LinkedList<String> dogs;
    MyQueue<String> q;

    public AnimaShelter(){
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
        q = new MyQueue<>();
    }

    public void enqueue(String animal){
        q.add(animal);
        if (animal.charAt(0) == 'C'){
            cats.add(animal);
        }
        else if (animal.charAt(0) == 'D'){
            dogs.add(animal);
        }
    }

    public String dequeueAny(){
        String temp = q.peek();
        if (temp.charAt(0) == 'C'){
            cats.remove(temp);
        } else if (temp.charAt(0) == 'D'){
            dogs.remove(temp);
        }
        return temp;
    }

    public String dequeueDog(){
        String temp = q.peek();
        MyStack<String> tempStack = new MyStack<>();
        while (temp.charAt(0) != 'D'){
            tempStack.push(temp);
            temp = q.remove();
        }
        if (q.isEmpty()) return "NO DOGS";
        while (!tempStack.isEmpty()){
            q.add(tempStack.pop());
        }
        dogs.remove(temp);
        return temp;
    }

    public String dequeueCat(){
        String temp = q.peek();
        MyStack<String> tempStack = new MyStack<>();
        while (temp.charAt(0) != 'C'){
            tempStack.push(temp);
            temp = q.remove();
        }
        if (q.isEmpty()) return "NO CATS";
        while (!tempStack.isEmpty()){
            q.add(tempStack.pop());
        }
        cats.remove(temp);
        return temp;
    }
}
