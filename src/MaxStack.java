import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if(maxStack.isEmpty()){
            maxStack.push(value);
        } else {
            int prev = maxStack.peek();
            value = Math.max(value, prev);
            maxStack.push(value);
        }
    }

    public int pop(){
        int el = stack.pop();
        maxStack.pop();
        return el;
    }

    public int top(){
        return stack.peek();
    }

    public int popMax(){
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while(stack.peek() != max){
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop(); //удаляем максимум
        maxStack.pop();
        while (!temp.isEmpty()){
            push(temp.pop());
        }
        return max;
    }

    public int peekMax(){
        return maxStack.peek();
    }
}

