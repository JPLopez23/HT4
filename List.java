public interface List<E> {
    void add(E item, int index);
    E remove(int index);
    E get(int index);
    boolean isEmpty();
    int size();
}
