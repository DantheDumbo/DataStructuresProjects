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
        return pointer == 0;
    }
    public boolean isFull() {
        return pointer == 9;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i=0; i<pointer; i++) {
            str += stack[i] + "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println(stack.isEmpty());

        stack.push(8);

        System.out.println(stack.isEmpty());

        stack.push(7);
        stack.push(0);
        stack.push(82);
        stack.push(1);

        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());

        System.out.println();

        System.out.println(stack);

        System.out.println(stack.size());

        System.out.println();

        System.out.println(stack.isFull());

        stack.push(-1);
        stack.push(-1);
        stack.push(-1);
        stack.push(-1);
        stack.push(-1);

        System.out.println(stack.isFull());

        System.out.println(stack);

        System.out.println(stack.size());
    }
}
