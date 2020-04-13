package datastructures;

import java.util.Iterator;

public class LinkedTree<E> extends AbstractTree<E> {

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private DoublyLinkedList<Position<E>> children;

        public Node(E element, Node<E> parent, DoublyLinkedList<Position<E>> children) {
            this.element = element;
            this.parent = parent;
            this.children = children;
        }

        public Node(E element, Node<E> parent, Position<E>... children) {
            this.element = element;
            this.parent = parent;
            DoublyLinkedList<Position<E>> temp = new DoublyLinkedList<>();
            for (Position<E> child : children) {
                temp.addLast(child);
            }
            this.children = temp;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public DoublyLinkedList<Position<E>> getChildren() {
            return children;
        }

        public void setChildren(DoublyLinkedList<Position<E>> children) {
            this.children = children;
        }
    }

    protected Node<E> root = null;
    protected int size = 0;

    public LinkedTree() {
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if(!(position instanceof Node)) {
            throw new IllegalArgumentException("node from this tree");
        }
        Node<E> node = (Node<E>) position;
        if(node.getParent() == node) {
            throw new IllegalArgumentException("Այս նոդն արդեն մահացել ա :'(");
        }
        return node;
    }

    @Override
    public Position<E> parent(Position<E> p) {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        Node<E> node = validate(p);
        return node.getChildren();
    }

    @Override
    public boolean isRoot(Position<E> p) {
        Node<E> node = validate(p);
        return node == root;
    }

    @Override
    public boolean isInternal(Position<E> p) {
        Node<E> node = validate(p);
        return node.getChildren().size() > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) {
        return !isInternal(p);
    }

    @Override
    public int numChildren(Position<E> p) {
        Node<E> node = validate(p);
        return node.getChildren().size();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) {
            throw new IllegalStateException();
        }
        root = new Node<E>(e, null, new DoublyLinkedList<Position<E>>());
        size = 1;
        return root;
    }

    public Position<E> addChild(E e, Position<E> p) {
        Node<E> parent = validate(p);
        Node<E> newest = new Node<E>(e, parent, new DoublyLinkedList<Position<E>>());
        parent.getChildren().addLast(newest);
        size++;
        return newest;
    }

    public String toString(Position<E> root) {
        if(root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(root.getElement());
        if(isInternal(root)) {
            boolean firstTime = true;
            for(Position<E> c : children(root)) {
                str.append( (firstTime ? " (" : ", ") );
                firstTime = false;
                str.append(toString(c));
            }
            str.append(")");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return toString(root);
    }


    //ex 8.c28
    private int pathLengthHelper(Position<E> root) {
        int result = 0;
        for(Position<E> c : children(root)) {
            result += 1 + pathLengthHelper(c);
        }
        return result;
    }

    public int pathLength() {
        return pathLengthHelper(root);
    }


    private void allLeafNodesHelper(Position<E> root, DoublyLinkedList<Position<E>> list) {
        if(numChildren(root) == 0) {
            list.addLast(root);
        } else {
            for(Position<E> c : children(root)) {
                allLeafNodesHelper(c, list);
            }
        }
    }

    public DoublyLinkedList<Position<E>> allLeafNodes() {
        DoublyLinkedList<Position<E>> result = new DoublyLinkedList<>();
        allLeafNodesHelper(root, result);
        return result;
    }
}
