package BTVN.Day3.StackQueue;

class Queue extends SLL {
    int queueSize;
    SLL A;

    Queue(int size) {
        A = new SLL();
        queueSize = size;
    }

    void enqueue(int x) {
        if (getLength() >= queueSize) {    //getLength() == QueueSize
            System.out.println("\n" + "Queue is full !! Cannot push " + x + " to Queue");
        } else {
            System.out.println("\n" + "Added " + x + " to Queue");
            insertAtFront(x);
        }

    }

    int dequeue() {
        if (getLength() == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        System.out.print("\n" + "Pop out ");
        return deleteFromRear();
    }

    int size() {
        return getLength();
    }

    boolean isFull() {
        boolean full = true;
        if (getLength() < queueSize) full = false;
        return full;
    }

    boolean isEmpty() {
        boolean empty = true;
        if (getLength() > 0) empty = false;
        return empty;
    }

    void peek() {
        if (getLength() == 0)
            System.out.println("Rỗng !!");
        else printLast();
//         else int peek=getLast();System.out.println("Last element: "+peek);
    }

    void print() {
        System.out.println("\n");
        printALL();
        System.out.println("\n");
    }
}