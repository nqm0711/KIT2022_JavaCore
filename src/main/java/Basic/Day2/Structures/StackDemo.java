package Basic.Day2.Structures;

public class StackDemo {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        st.push(110);
        st.push(120);
        st.push(130);
        st.push(140);
    }
}
