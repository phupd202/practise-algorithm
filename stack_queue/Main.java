package stack_queue;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        // push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 1 2 3 <-

        // stack
        System.out.println("Pop : " + stack.pop());

        // peek
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size after peek: " + stack.size());


        // push
        stack.push(4);
        System.out.println("2st pop: " + stack.pop());

        // peek 
        System.out.println("2st peek: " + stack.peek());
        
        // push
        stack.push(5);
        System.out.println("Pop 5: " + stack.pop());
        stack.peek();
        System.out.println("Size after peek 5: " + stack.peek());
    }
}
