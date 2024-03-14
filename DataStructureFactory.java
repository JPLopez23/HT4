public class DataStructureFactory {

    public static <E> Stack<E> createStack(String type) {
        if ("ArrayList".equalsIgnoreCase(type)) {
            return new ArrayListStack<>();
        } else if ("Vector".equalsIgnoreCase(type)) {
            return new VectorStack<>();
        }
        throw new IllegalArgumentException("Unknown Stack type: " + type);
    }

    public static <E> List<E> createList(String type) {
        if ("SinglyLinkedList".equalsIgnoreCase(type)) {
            return new SinglyLinkedList<>();
        } else if ("DoublyLinkedList".equalsIgnoreCase(type)) {
            return new DoublyLinkedList<>();
        }
        throw new IllegalArgumentException("Unknown List type: " + type);
    }
}
