package tree.tree_adt;

/*
 * Idea: 
 * - Implement binary tree with array 
 * - Ct: note: a[i] --> leaf = a[2 * i], a[2 * i  + 1], index begin from 1
 */
public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    // constructor
    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E root) {
        if(n > 0) {
            throw new IllegalArgumentException("The binary tree has root!");
        } 

        array[0] = null;
        array[1] = root;

    }

    public void setLeft(int idxNode, E left) {
        if(idxNode <= 1 || idxNode > defaultSize - 1) {
            throw new IllegalArgumentException("Index of node to set is not valid");
        }

        if(this.array[idxNode] == null) {
            throw new IllegalArgumentException("The node is passed is not valid");
        }        

        array[idxNode * 2] = left;
    }

    public void setRight(int idxNode, E right) {
        if(idxNode <= 1 || idxNode > defaultSize - 1) {
            throw new IllegalArgumentException("Index of node to set is not valid");
        }

        if(this.array[idxNode] == null) {
            throw new IllegalArgumentException("The node is passed is not valid");
        }

        array[idxNode * 2 + 1] = right;
    }
    

    @Override
    public E root() {
        return isEmpty() ? null : this.array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(E p) {
        int num = 0;
        for (int i = 1; i < size(); i++) {
            if(array[i] == p) {
                // left node
                if(array[2 * i] != null) {
                    num++;
                }

                // right node
                if(array[2 * i + 1] != null) {
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public E parent(E p) {
        int idxParent = -1;
        for (int i = 1; i < size(); i++) {
            if(array[i].equals(p)) {
                idxParent = i / 2;
                break;
            }
        }

        return idxParent >= 1 && idxParent <= size() - 1 ? this.array[idxParent] : null;
    }

    @Override
    public E left(E p) {
        int idxLeft = -1;
        for (int i = 1; i < size(); i++) {
            if(array[i].equals((p))) {
                idxLeft = 2 * i;
                break;
            }
        }

        return idxLeft < size() ? this.array[idxLeft] : null;
    }

    @Override
    public E right(E p) {
        int idxRight = -1;
        for (int i = 1; i < size(); i++) {
            if(array[i].equals(p)) {
                idxRight = 2 * i + 1;
                break;
            }
        }
        return idxRight < size() ? this.array[idxRight] : null;
    }

    @Override
    public E sibling(E p) {
        int idxNode = getIndex(p);

        return idxNode > 0 && idxNode % 2 == 0? this.array[2 * idxNode + 1] : this.array[2 * idxNode];
    }

    public int getIndex(E p) {
        for (int i = 1; i < size(); i++) {
            if(this.array[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }
}
