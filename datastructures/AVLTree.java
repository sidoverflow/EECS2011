package datastructures;

public class AVLTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {


    private int size;
    private Node<E> root;

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(45);
        avl.insert(63);
        avl.insert(73);
        avl.insert(34);
        avl.insert(3);
//        avl.insert(74);
//        avl.insert(64);
        //avl.remove(45);
        System.out.println("start inorder");
        for(Position<Integer> c : avl.inorder()) {
            System.out.print(c + ", ");
        }
        System.out.println("\nstart BFT");
        for(Position<Integer> c : avl.breadthfirst()) {
            System.out.print(c + ", ");
        }
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private Node<E> createNode(E el, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(el, parent, left, right);
    }

    private Position<E> parentToInset(E el) {
        // Modified version of the search function, instead of returning null if the key is not in the tree, this return
        // the position that could be the parent of the node with this key
        Node<E> temp = root;
        while (temp != null) {
            if (el.equals(temp.getElement())) {
                return temp;
            } else if (el.compareTo(temp.getElement()) < 0) {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                } else {
                    return temp;
                }
            } else {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                } else {
                   return temp;
                }
            }
        }
        return null;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return node.getHeight();
        }
    }

    private int balanceFactor(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node<E> leftRotate(Node<E> node) {
        if (node == null || node.getRight() == null) {
            return null;
        }
        Node<E> z = node.getRight();
        if (node.getParent() != null) {
            if (node == node.getParent().getRight()) {
                node.getParent().setRight(z);
            } else {
                node.getParent().setLeft(z);
            }
        } else {
            root = z;
        }
        z.setParent(node.getParent());
        if (z.getLeft() != null) {
            z.getLeft().setParent(node);
        }
        node.setRight(z.getLeft());
        z.setLeft(node);
        node.setParent(z);
        return z;
    }

    private Node<E> rightRotate(Node<E> node) {
        if (node == null || node.getLeft() == null) {
            return null;
        }

        Node<E> x = node.getLeft();
        if (node.getParent() != null) {
            if (node == node.getParent().getLeft()) {
                System.out.println(node);
                node.getParent().setLeft(x);
            } else {
                node.getParent().setRight(x);
            }
        } else {
            root = x;
        }
        x.setParent(node.getParent());
        if (x.getRight() != null) {
            x.getRight().setParent(node);
        }
        node.setLeft(x.getRight());
        x.setRight(node);
        node.setParent(x);
        return x;
    }

    private void heightify(Node<E> node) {
        if(node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    private void rebalance(Node<E> node) {
        while (node != null) {
            if (balanceFactor(node) > 1) {
                if (balanceFactor(node.getLeft()) <= 0) {
                    node = leftRotate(node.getLeft());
                    node = node.getParent();
                }
                node = rightRotate(node);
            }

            if (balanceFactor(node) < -1) {
                if (balanceFactor(node.getRight()) > 0) {
                    node = rightRotate(node.getRight());
                    node = node.getParent();
                }
                node = leftRotate(node);
            }

            //TODO: most probably there exist better solution for this, but I'm to lazy to rethink about notations again
            //by rotating we can change the height of a node and forget about it forever
            heightify(node);
            heightify(node.getRight());
            heightify(node.getLeft());
            node = node.getParent();
        }
    }

    public void insert(E el) {
        if (isEmpty()) {
            root = createNode(el, null, null, null);
            size++;
        } else {
            Position<E> p = parentToInset(el);
            Node<E> node = validate(p);
            if (p.getElement().equals(el)) {
                node.setElement(el);
            } else {
                Node<E> newest = createNode(el, node, null, null);
                if (el.compareTo(node.getElement()) > 0) {
                    node.setRight(newest);
                } else {
                    node.setLeft(newest);
                }
                rebalance(node);
                size++;
            }
        }
    }

    private Node<E> transplant(Node<E> u, Node<E> v) {
        if (u == null) {
            return null;
        }
        if (u.getParent() == null) {
            root = v;
        } else if (u.getParent().getRight() == u) {
            u.getParent().setRight(v);
        } else {
            u.getParent().setLeft(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
        return u.getParent();
    }

    public void remove(E el) {
        Position<E> p = parentToInset(el);
        Node<E> node = validate(p);
        System.out.println(node);
        if (!p.getElement().equals(el)) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            node = transplant(node, null);
            size--;
        } else if (node.getRight() == null) {
            node = transplant(node, node.getLeft());
            size--;
        } else if (node.getLeft() == null) {
            transplant(node, node.getRight());
        } else {
            Node<E> right = node.getRight();
            Node<E> leftMost = right;
            while (leftMost.getLeft() != null) {
                leftMost = leftMost.getLeft();
            }
            node.setElement(leftMost.getElement());
            node = transplant(leftMost, leftMost.getRight());
        }
        rebalance(node);
    }

    private static class Node<E extends Comparable<E>> implements Position<E> {

        private int height;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private E data;

        public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
            height = 1;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return data;
        }

        public void setElement(E data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public String toString() {
            return this.getElement().toString() + " my height is: " + height;
        }
    }
}