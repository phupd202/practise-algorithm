package stack_queue;

public interface StackInterface<T> {
    void push(T element);

    T pop();

    boolean isEmty();

    int size();

    T peek();
}
