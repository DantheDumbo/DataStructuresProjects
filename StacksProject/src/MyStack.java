public class MyStack {

    private int[] stack;
    int pointer;

    public MyStack() {
        stack = new int[10];
        pointer = 0;
    }

    public void push(int num) {
        if (pointer < 9) {
            stack[pointer] = num;
            pointer++;
        }
    }
    public int pop() {
        pointer--;
        return stack[pointer];
    }
    public int peak() {
        return stack[pointer-1];
    }
    public int size() {
        return pointer;
    }
    public boolean isEmpty() {
        return pointer != 9;
    }
    public boolean isFull() {
        return pointer == 9;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
         
    }
}
