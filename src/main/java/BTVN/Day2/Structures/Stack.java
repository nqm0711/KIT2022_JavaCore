package BTVN.Day2.Structures;

public class Stack {
    int size;
    int top;// [0,size-1]
    int[] A;

    Stack(int size) {
        top = -1;
        A = new int[size];
    }

    void push(int x) {
        if (top >= A.length - 1) {
            System.out.println("Stack is full while pushing "+x);
            return;
        }
        top++;
        A[top] = x;
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        top--;
        System.out.print("Pop out ");
        return A[top + 1];
    }
}
