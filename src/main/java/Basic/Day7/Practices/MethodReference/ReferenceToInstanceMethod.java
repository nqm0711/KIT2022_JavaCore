package Basic.Day7.Practices.MethodReference;

interface Adder {
    void addAndPrint(int a, int b);
}

public class ReferenceToInstanceMethod {
    public void PrintSum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum :"+sum);
    }

    public static void main(String[] args) {
        ReferenceToInstanceMethod testObject = new ReferenceToInstanceMethod(); // Creating object
        Adder tinhTong = testObject::PrintSum; // Referring non-static method using reference
        tinhTong.addAndPrint(10,15); // Calling interface method
// Referring non-static method using anonymous object
        Adder tinhTong2 = new ReferenceToInstanceMethod()::PrintSum;
        tinhTong2.addAndPrint(30,40); // Calling interface method
    }
}

//interface Sayable {
//    void say();
//}
//
//public class ReferenceToInstanceMethod {
//    public void saySomething() {
//        System.out.println("Hello, this is non-static method.");
//    }
//
//    public static void main(String[] args) {
//        ReferenceToInstanceMethod methodReference = new ReferenceToInstanceMethod(); // Creating object
//        Sayable sayable = methodReference::saySomething; // Referring non-static method using reference
//        sayable.say(); // Calling interface method
//// Referring non-static method using anonymous object
//        Sayable sayable2 = new ReferenceToInstanceMethod()::saySomething;
//        sayable.say(); // Calling interface method
//    }
//}
