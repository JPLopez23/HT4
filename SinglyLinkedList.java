public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
        } else {
            Node<E> prev = getNode(index - 1);
            removedElement = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return removedElement;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> node = getNode(index);
        return node.element;
    }

    private Node<E> getNode(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}