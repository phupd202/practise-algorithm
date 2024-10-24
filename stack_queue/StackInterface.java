package stack_queue;

import java.util.Collection;
import java.util.List;

public interface StackInterface<T> {
    void push(T element);

    void pushAll(List<T> items);

    T pop();

    boolean isEmty();

    int size();

    T peek();
}
