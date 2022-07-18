package Basic.Day3.Polymorphism;

public class Test2 {
    class Animal {

            void eat() {
                System.out.println("eating");
            }
        }

        class Dog extends Test2.Animal {

            void eat() {
                System.out.println("eating bones");
            }
        }

        class BabyDog extends Test2.Animal {

            void eat() {
                System.out.println("drinking milk");
            }

        }
        public static void main(String args[]) {
            Test2.Animal a1, a2, a3;
            Test2 a= new Test2();
            a1 =a.new Animal();
            a2 = a.new Dog();
            a3 = a.new BabyDog();
            a1.eat();
            a2.eat();
            a3.eat();
            System.out.println(a);
        }
    }
