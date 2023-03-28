import java.util.Arrays;

public class Queue<E> {
    E[] collection = (E[]) new Object[5];
    int arraySize = 5;
    int counter;
    int insertPointer;
    int retrievePointer;

    public Queue(){}

    public Queue(int size){
        collection = (E[]) new Object[size];
        arraySize = size;
    }

    public void enqueue(E item){
        if (item == null)
            throw new IllegalArgumentException();

        if (isFull())
            return;

        collection[insertPointer] = item;

        insertPointer = (insertPointer + 1) % arraySize;
        counter++;
    }

    public E dequeue(){
        if (isEmpty())
            return null;

        E item = collection[retrievePointer];

        retrievePointer = (retrievePointer  + 1) % arraySize;
        counter--;

        return item;
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public boolean isFull(){
        return counter == arraySize;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(collection);
    }
}
