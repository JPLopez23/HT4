import java.util.List;
import java.util.EmptyStackException;

public class ListStack<E> implements Stack<E> {
    private List<E> backendList;

    public ListStack(List<E> backendList) {
        this.backendList = backendList;
    }

    @Override
    public void push(E item) {
        backendList.add(0, item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return backendList.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return backendList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return backendList.isEmpty();
    }

    @Override
    public int size() {
        return backendList.size();
    }
}
