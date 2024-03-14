import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements Stack<E> {
    private ArrayList<E> list;
    

    public ArrayListStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(E item) {
        list.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}