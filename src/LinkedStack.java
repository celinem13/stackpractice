import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
    private int def_size = 50;
    private int size;
    private final int MAX_SIZE = 10000;
    private int counter = 0;
    private Node firstNode;

    public LinkedStack(){
        size = def_size;
    }

    public LinkedStack(int size){
        this.size = size;
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        if (size == MAX_SIZE)
            System.out.println("Push unsuccessful.");
        else{
            Node newTop = new Node(newEntry, firstNode);
            firstNode = newTop;
            counter++;
            System.out.println("Push successful.");
        }
    }

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        //top = top.nextNode;
        //catch the exception -- you're trying to pop an empty stack
        //try popping
        //catch the exception and print error message
        if (isEmpty()){
            System.out.println("Pop unsuccessful.");
            throw new EmptyStackException();
        }
        else{
            T returnItem = firstNode.item;
            firstNode = firstNode.next;
            counter--;
            System.out.println("Pop successful");
            return returnItem;
        }
    }

    /**
     * Retrieves this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return firstNode.item;
        }
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return counter==0;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        for (int i = 0; i< counter; i++){
            pop();
        }
        counter =0;
        size = 0;
        System.out.println("Clear successful.");
    }

    private class Node{
        T item;
        Node next;

        private Node() {
            this(null,null);
        }

        private Node(T item) {
            this(item,null);
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
