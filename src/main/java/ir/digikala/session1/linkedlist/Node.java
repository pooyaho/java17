package ir.digikala.session1.linkedlist;

public class Node<T> {
    private T data;
    private Node<T> next;

    // Constructor to create a new node
    // Next is by default initialized
    // as null
    public Node(T d) {
        data = d;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
