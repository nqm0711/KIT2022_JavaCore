package Basic.Day3.LinkedList.SinglyLinkedList;

class Element {
    int data;
    Element next;

    Element(int x) {
        data = x;
        next = null;
    }

    Element(int x, Element elNext) {
        data = x;
        next = elNext;
    }
}

class SinglyLinkedList {
    Element head;

    SinglyLinkedList() {
        head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtFirst(int x) {
        if (isEmpty()) {
            head = new Element(x);
        } else {
            head = new Element(x, head);
        }
    }
    void insertAtLast(int x) {
        if (isEmpty()) {
            head = new Element(x);
        } else {
            Element el = head;
            while (el.next != null) {el = el.next;}
            el.next = new Element(x);
        }
    }
    void printAll() {
        Element el = head;
        if (el != null) {
            System.out.print(el.data);
            el = el.next;
        }
        while (el != null) {
            System.out.print(", "+el.data);
            el = el.next;
        }
    }
    void printLast() {
        Element el = head;
        while (el != null&&el.next != null) {el = el.next;}
        System.out.println(" Phần tử cuối cùng :"+el.data );
    }
}
