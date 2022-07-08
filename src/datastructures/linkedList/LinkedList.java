package datastructures.linkedList;

public class LinkedList<T extends Comparable<T>> {

    class Node {

        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        /* Getter and Setter Methods */

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Inserts new Node as head
     *
     * @param value
     */
    public void insert(T value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            this.tail = newNode;
        }

        newNode.setNext(this.head);

        this.head = newNode;
        this.size++;
    }

    /**
     * Inserts new Node at the end of the list
     *
     * @param value
     */
    public void append(T value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }

        this.tail.setNext(newNode);
        this.tail = newNode;
        this.size++;
    }

    public boolean remove(T value) {

        if (isEmpty())
            return false;

        Node current = this.head;
        Node previous = null;

        while (current != null) {

            if (current.getValue().equals(value)) {

                if (previous != null) {
                    previous.setNext(current.getNext());

                    if (current.getNext() == null)
                        this.tail = previous;

                } else {
                    this.head = head.getNext();

                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                this.size--;
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public void removeFirst() {

        if (isEmpty())
            return;

        this.head = this.head.getNext();

        if (head == null || this.head.getNext() == null)
            this.tail = this.head;

        this.size--;
    }

    public boolean removeNth(int index) {

        if (isEmpty())
            return false;

        int currentIndex = 0;
        Node current = this.head;
        Node previous = null;

        while (current != null) {

            if (currentIndex == index) {
                if (previous != null) {
                    previous.setNext(current.getNext());

                    if (current.getNext() == null)
                        this.tail = previous;

                } else {
                    this.head = head.getNext();

                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                this.size--;
                return true;
            }

            previous = current;
            current = current.getNext();
            currentIndex++;
        }

        return false;
    }

    public Node get(T value) {

        if (isEmpty())
            return null;

        Node current = this.head;

        while (current != null) {

            if (current.getValue().equals(value))
                return current;

            current = current.getNext();
        }

        return null;
    }

    public boolean has(T value) {
        return get(value) != null;
    }

    /**
     * Returns value at given index, if node at index does not exists return null
     *
     * @param index Index of the node
     * @return Return value of node at given index or null if node at index does not exist or list is empty
     */
    public T valueAt(int index) {

        if (isEmpty()) {
            return null;
        }

        int currentIndex = 0;
        Node current = this.head;

        while (current != null) {

            if (currentIndex == index)
                return current.getValue();

            currentIndex++;
            current = current.getNext();
        }

        return null;
    }

    public void print() {

        String res = "Head->";

        Node temp = this.head;

        while (temp != null) {

            res += "[" + temp.getValue() + "]->";
            temp = temp.getNext();
        }

        res += "Null";

        System.out.println(res);
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(1);
        list.print();
        list.removeFirst();

        list.print();

        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.print();

        list.append(6);

        list.print();

        System.out.println(list.has(1));
        System.out.println(list.get(2).getValue());

        list.remove(3);
        list.print();
        System.out.println(list.valueAt(0));
        System.out.println(list.valueAt(4));
        list.removeNth(0);
        list.removeNth(10);
        System.out.println(list.size());
        list.print();
    }
}
