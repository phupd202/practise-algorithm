package stack_queue;

import java.util.List;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int defaultSize = 100;
    private int n = 0;

    // constructor
    public ArrayStack() {
        this.stack = (T[]) new Object[defaultSize];
    }

    @Override
    public void push(T element) {
        if(n >= this.defaultSize) {
            System.arraycopy(stack, 0, stack, 0, n * 2);
        }
        stack[n++] = element;
    }

    @Override
    public T pop() {
        return this.size() > 0 ? stack[n - 1] : null;
    }

    @Override
    public T peek() {
        T result = this.stack[n - 1];
        n--;
        return result;
    }
    

    @Override
    public boolean isEmty() {
       return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void pushAll(List<T> items) {
        if(items.isEmpty()) {
            return;
        }
        items.forEach(item -> this.push(item));
    } 
}
