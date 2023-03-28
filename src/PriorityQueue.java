import java.util.Arrays;

public class PriorityQueue {
    private int[] array = new int[5];
    private int arraySize = 5;
    private int counter;
    private int insertPointer;
    private int retrievePointer;

    public PriorityQueue(){}

    public PriorityQueue(int arraySize){
        array = new int[arraySize];
        this.arraySize = arraySize;
    }

    public void add(int item){
        if (item == 0)
            throw new IllegalArgumentException();

        if (isFull())
            return;

        if (isEmpty()) {
            addItemAtOriginalInsertPointer(item);
            return;
        }

        int currentIndex = insertPointer;
        int previousIndex;

        for (int num = 1; num <= counter; num++){
            previousIndex = calculatePreviousIndex(currentIndex);

            if (item >= array[previousIndex])
                break;

            currentIndex = previousIndex;
        }

        int newInsertPointer = currentIndex;

        if (newInsertPointer == insertPointer){
            addItemAtOriginalInsertPointer(item);
            return;
        }

        currentIndex = insertPointer;


        while (currentIndex != newInsertPointer) {
            previousIndex = calculatePreviousIndex(currentIndex);
            array[currentIndex] = array[previousIndex];
            currentIndex = previousIndex;
        }

        array[newInsertPointer] = item;

        insertPointer = (insertPointer + 1) % arraySize;
        counter++;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        int item = array[retrievePointer];

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

    private int calculatePreviousIndex(int currentIndex){
        int previousIndex;

        if (currentIndex == 0)
            previousIndex = counter - 1;
        else
            previousIndex = currentIndex - 1;

        return previousIndex;
    }

    private void addItemAtOriginalInsertPointer(int item){
        array[insertPointer] = item;
        insertPointer = (insertPointer + 1) % arraySize;
        counter++;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
