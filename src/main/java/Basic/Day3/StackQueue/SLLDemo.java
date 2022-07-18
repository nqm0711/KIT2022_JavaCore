package Basic.Day3.StackQueue;

class Element {

    int data; //
    int size;
    Element next;// tham chiếu đến phần tử tiếp theo

    Element(int x) {
        data = x;
        next = null;
    }

    Element(int x, Element elNext) {
        data = x;
        next = elNext;
    }
}

class SLL {

    Element head;

    SLL() {
        head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtFront(int x) {
        if (isEmpty()) {
            head = new Element(x);
        } else {
            head = new Element(x, head);
        }

    }

    int deleteFromFront() {
        if (isEmpty()) {
            return -1;
        }
        int x = head.data;
        head = head.next;
        return x;
    }

    void insertAtRear(int x) {
        if (isEmpty()) {
            head = new Element(x);
        } else {
            Element el = head;
            while (el.next != null) {
                el = el.next;
            }
            el.next = new Element(x);
        }
    }

    int deleteFromRear() {
        if (isEmpty()) {
            return -1;
        }
        // 5 ->10 ->20 ->30
        int x;
        Element el = head, el1 = head;
        while (el.next != null) {
            el1 = el;
            el = el.next;
        }
        x = el.data;
        if (head == el) {
            head = null;
        } else {
            el1.next = null;
        }
        return x;
    }

    void printALL() {
        Element el = head;
        if (el != null) {
            System.out.print(el.data);
            el = el.next;
        }
        while (el != null) {
            System.out.print(", " + el.data);
            el = el.next;
        }
    }
    void printFirst(){
        if (head != null) {
            System.out.println("\n"+head.data);
        }
    }
    int getFirst(){
        if (head == null) return -1;
        return head.data;
    }
    void printLast(){
        Element el = head;
        while (el.next != null) {
            el = el.next;
        }
        System.out.print("\n"+el.data);
    }
    int getLast(){
        Element el = head;
        while (el.next != null) {
            el = el.next;
        }
        return el.data;
    }
    int getLength(){
        int length = 0;
        Element el = head;
        if (el==null){System.out.println("\n"+"EMPTY !!");length = 0;}
        else {
            while (el != null) {
                length++;
                el = el.next;
            }
            System.out.println("List's length: "+length);
        }
        return length;
    }
}


public class SLLDemo {
    public static void main(String[] args) {
        SLL sll = new SLL(); // Tạo ra một danh sách rỗng
        sll.printALL();
        sll.insertAtFront(10);
        sll.insertAtFront(5);
        sll.insertAtRear(20);
        sll.printALL();
    }
}