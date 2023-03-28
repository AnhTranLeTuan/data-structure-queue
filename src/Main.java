import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        SolveProblemsWithQueue.reverseQueue(queue);
        System.out.println("Reversed queue: " + queue);

        Queue<Integer> queue2 = new Queue<>(3);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        System.out.println("\n" + "Queue: " + queue2);

        Deque<Integer> implementedQueueByStack = SolveProblemsWithQueue.UsingStacksToImplementQueue(queue2);

        System.out.println("Implemented queue using stack: " +
                "\n" + implementedQueueByStack.pop() +
                "\n" + implementedQueueByStack.pop() +
                "\n" + implementedQueueByStack.pop());

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.toString());

        System.out.println("\n" + priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }



}