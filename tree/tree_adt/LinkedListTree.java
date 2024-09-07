package tree.tree_adt;

public class LinkedListTree<E> {
    private int n = 0;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Node<E> addLeft(E left, Node<E> node) {
        if(node.getElement() == null) {
            throw new IllegalArgumentException("The node is not exist element");
        }

        if(left == null) {
            throw new IllegalArgumentException("The left is null! Invalid");
        }

        Node<E> leftNode = new Node<E>(left, node, null, null);
        node.setLeft(leftNode);
        n++;
        return node;
    }

    public Node<E> addRight(E p, Node<E> node) {
        if(node.getElement() == null) {
            throw new IllegalArgumentException("The node is not exist element");
        }

        if(p == null) {
            throw new IllegalArgumentException("The right is null! Invalid");
        }

        Node<E> rightNode = new Node<E>(p, node, null, null);
        node.setRight(rightNode);
        n++;
        return node;
    }

    public Node<E> addRoot(E p) {
        if(!isEmpty()) {
            throw new IllegalArgumentException("The tree has existed root!!");
        }
        Node<E> root  = new Node<E>(p, null, null, null);
        return root;
    }
    
    // travel 
    public void inOrder(Node<E> root) {
        if(root == null) {
            return;
        }

        E element =  (E) root.getElement();

        // travel
        inOrder(root.getLeft());
        System.out.println(element.toString());
        inOrder(root.getRight());
    }

    public void posOrder(Node<E> root) {
        if(root == null) {
            return;
        }

        E element =  (E) root.getElement();

        // travel
        posOrder(root.getLeft());
        posOrder(root.getRight());
        System.out.println(element.toString());
    }

    public void preOrder(Node<E> root) {
        if(root == null) {
            return;
        }

        E element =  (E) root.getElement();

        // travel
        System.out.println(element.toString());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    

    public static void main(String[] args) {
        LinkedListTree<Integer> tree = new LinkedListTree<Integer>();

        Node<Integer> root = tree.addRoot(2);
        tree.addLeft(1, root);
        tree.addRight(3, root);

        // travel with in order
        System.out.println("=====================Pre Order==================");
        tree.preOrder(root);
        System.out.println("=====================In Order==================");
        tree.inOrder(root);
        System.out.println("=====================Pos Order==================");
        tree.preOrder(root);
    }
}
