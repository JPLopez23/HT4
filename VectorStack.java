import java.util.Vector;
import java.util.EmptyStackException;

public class VectorStack<E> implements Stack<E> {
    private Vector<E> vector;

    public VectorStack() {
        vector = new Vector<>();
    }

    @Override
    public void push(E item) {
        vector.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return vector.remove(vector.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return vector.get(vector.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public int size() {
        return vector.size();
    }
}