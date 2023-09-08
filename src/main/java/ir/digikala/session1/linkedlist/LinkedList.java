package ir.digikala.session1.linkedlist;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add("Item " + i);
        }
        linkedList.remove("Item 0");
        for (String i : linkedList) {
            System.out.println(i);
        }
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    private Node<T> findNode(T item) {
        if (head == null || item == null) {
            return null;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getData().equals(item)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void remove(T item) {
        Node<T> node = findNode(item);
        if (node == null) {
            throw new ItemNotFoundException();
        }

        Node<T> beforeNode = null;
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext() == node) {
                beforeNode = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if (beforeNode == null) {
            head = head.getNext();
        } else {
            beforeNode.setNext(node.getNext());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> root = LinkedList.this.head;

            @Override
            public boolean hasNext() {
                return root != null;
            }

            @Override
            public T next() {

                if (root == null) {
                    return null;
                }
                T data = root.getData();
                root = root.getNext();
                return data;
            }
        };
    }

}