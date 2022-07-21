package BTVN.Day3.StackQueue;

public class Main {
    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.enqueue(10);
        qu.enqueue(20);
        qu.enqueue(30);
        qu.print();
        System.out.println(qu.dequeue());
        qu.enqueue(110);
        qu.enqueue(120);
        qu.enqueue(130);
        qu.enqueue(140);
        qu.print();
        //////////////////////////////////////////////////////////////////////////////////////
        Stack st = new Stack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.print();
        System.out.println(st.pop());
        st.push(110);
        st.push(120);
        st.push(130);
        st.push(140);
        st.print();
    }
}