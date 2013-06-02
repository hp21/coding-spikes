package tree;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>(null, null, null, rootData);
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + '}';
    }
}
