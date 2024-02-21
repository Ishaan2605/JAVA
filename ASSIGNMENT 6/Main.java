interface Stack {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
}

class FixedStack implements Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public FixedStack(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push " + item);
            return;
        }
        stackArray[++top] = item;
        System.out.println(item + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class GrowableStack implements Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public GrowableStack(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1) {
            int[] newStack = new int[capacity * 2];
            System.arraycopy(stackArray, 0, newStack, 0, capacity);
            capacity *= 2;
            stackArray = newStack;
        }
        stackArray[++top] = item;
        System.out.println(item + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Fixed Stack Example:");
        Stack fixedStack = new FixedStack(3);
        fixedStack.push(1);
        fixedStack.push(2);
        fixedStack.push(3);
        fixedStack.push(4); // This will cause stack overflow
        System.out.println("Popped: " + fixedStack.pop());
        System.out.println("Peek: " + fixedStack.peek());
        System.out.println("Popped: " + fixedStack.pop());
        System.out.println("Popped: " + fixedStack.pop());
        System.out.println("Popped: " + fixedStack.pop()); // This will cause stack underflow

        System.out.println("\nGrowable Stack Example:");
        Stack growableStack = new GrowableStack(3);
        growableStack.push(1);
        growableStack.push(2);
        growableStack.push(3);
        growableStack.push(4); // This will grow the stack
        System.out.println("Popped: " + growableStack.pop());
        System.out.println("Peek: " + growableStack.peek());
        System.out.println("Popped: " + growableStack.pop());
        System.out.println("Popped: " + growableStack.pop());
        System.out.println("Popped: " + growableStack.pop()); // This will cause stack underflow
    }
}
