import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SolveProblemsWithQueue {

    public static void reverseQueue(Queue<Integer> queue){
        if (queue == null)
            throw new IllegalArgumentException();

        Deque<Integer> stack = new ArrayDeque<>();

        while (!queue.isEmpty())
            stack.push(queue.dequeue());

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        queue.toString();
    }

    public static Deque<Integer> UsingStacksToImplementQueue(Queue<Integer> queue){
        Deque<Integer> intermediateStack = new ArrayDeque<>();
        Deque<Integer> finalStack = new ArrayDeque<>();

        while (!queue.isEmpty())
            intermediateStack.push(queue.dequeue());

        while (!intermediateStack.isEmpty())
            finalStack.push(intermediateStack.pop());

        return finalStack;
    }
}
