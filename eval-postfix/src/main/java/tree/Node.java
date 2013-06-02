package tree;

public class Node<T> {

    private T data;
    private Node<T> parent;
    private Node<T> right;
    private Node<T> left;

    public Node() {
    }

    public Node(T data) {
        this(null, null, null, data);
    }

    public Node(Node<T> left, Node<T> parent, Node<T> right, T data) {
        this.left = left;
        this.parent = parent;
        this.right = right;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", parent=" + parent + ", right=" + right + ", left=" + left + '}';
    }
}
