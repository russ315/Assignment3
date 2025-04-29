import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {

    private Node root;

    public class Node {
        private final K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size) {
            this.key   = key;
            this.val   = val;
            this.size  = size;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else
            x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null)  return x.right;
            if (x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left  = t.left;
        }

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        return (x.left == null) ? x : min(x.left);
    }

    @Override
    public Iterator<Node> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node> {
        private final Stack<Node> stack = new Stack<>();

        public InOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Node curr = stack.pop();
            if (curr.right != null)
                pushLeft(curr.right);

            return curr;
        }
    }
}
