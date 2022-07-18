package Basic.Day3.StackQueue;

class Stack extends SLL {
    int stackSize;
     Stack(int size) {
        stackSize = size;
    }

    void push(int x) {
        if (getLength()== stackSize) {
            System.out.println("\n"+"Stack is full !! Cannot push "+x+" to stack");
        } else {
        System.out.println("\n"+"Added "+x+" to stack");
        insertAtRear(x);}

    }

    int pop() {
        if (getLength() == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.print("\n"+"Pop out ");
        return deleteFromRear();
    }

    int size(){
        return getLength();
    }

    boolean isFull(){
         boolean full = true;
         if (getLength() < stackSize) full = false;
         return full;
    }
    boolean isEmpty(){
        boolean empty = true;
        if (getLength() >0) empty = false;
        return empty;
    }
    void top(){
         if (getLength()==0)
         System.out.println("Rỗng !!");
         else printLast();
    }
    void print(){
         printALL();
    }
}