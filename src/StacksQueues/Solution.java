package StacksQueues;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        SortableStack stack = new SortableStack();
        Random r = new Random();
        for (int i = 0; i < 30; i++){
            stack.push(r.nextInt(100));
        }
        System.out.println(stack);
        stack.sort();
        System.out.println(stack);

        AnimaShelter as = new AnimaShelter();
        as.enqueue("C1");
        as.enqueue("C2");
        as.enqueue("D1");
        as.enqueue("D2");
        as.enqueue("C3");
        as.enqueue("C4");
        as.enqueue("D3");
        System.out.println(as.dequeueAny()); // C1
        System.out.println(as.dequeueDog()); // D1
        System.out.println(as.dequeueDog()); // D2
        System.out.println(as.dequeueCat()); // C2
        System.out.println(as.dequeueCat()); // C3
        System.out.println(as.cats);
        System.out.println(as.dogs);
    }
}
