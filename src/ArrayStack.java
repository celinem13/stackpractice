import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    private int def_size = 50;
    private int size;
    private final int MAX_SIZE = 10000;
    private T[] arrayStore;
    private int counter = 0;

    public ArrayStack(){
        size = def_size;
        arrayStore = (T[]) new Object[size];
    }

    public ArrayStack(int new_size){
        size = new_size;
        arrayStore = (T[]) new Object[new_size];
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */

    @Override
    public void push(T newEntry) {
        if (size == MAX_SIZE){
            System.out.println("Push unsuccessful.");
        }
        else{
            arrayStore[counter+1] = newEntry;
            counter++;
            System.out.println("Push successful.");
        }
    }

    /**
     * Removes and returns this stack's top entry.
     *private int def_size = 50;
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("Pop unsuccessful.");
            throw new EmptyStackException();
        }
        else{
            T top_element = arrayStore[counter];
            arrayStore[counter] = null;
            counter--;
            System.out.println("Pop successful.");
            return top_element;
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
            T top_element = arrayStore[counter];
            return top_element;
        }
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return (counter==0);
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        for (int i = 0; i < counter; i++){
            pop();
        }
        System.out.println("Clear successful.");
        counter = 0;
        size =0;
    }
}
