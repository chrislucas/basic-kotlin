package oop;

public class Test {

    class A {
        public void print() {
            System.out.println(getClass().getName());
        }
    }


    class B extends A {
        public void print() {
            System.out.println(getClass().getName());
        }
    }

    public static void main(String[] args) {
        A a = new Test().new B();
        a.print();
    }
}
