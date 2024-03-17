import java.util.Stack;

public class ImplementQueueUsingStack232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            int n = stack1.size();
            for (int i = 0; i < n; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null: stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            int n = stack1.size();
            for (int i = 0; i < n; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
