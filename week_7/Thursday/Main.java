class A {
    protected int x = 1;

    protected void calculate() {
        x *= 2;
    }

    static protected void staticCalculate(A obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("A: " + x);
    }
}

class B extends A {
    protected int x = 2;
    protected int y = 5;

    protected void calculate() {
        x *= 2;
        y += 10;
    }

    static protected void staticCalculate(B obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("B: x=" + x + ", y=" + y);
    }
}

public class Main {
    public static void main(String[] args) {
        A obj1 = new B();
        obj1.calculate();
        // A.staticCalculate(obj1);
        obj1.x += 10;
        obj1.display();

        B obj2 = new B();
        obj2.calculate();
        // B.staticCalculate(obj2);
        obj2.x += 10;
        obj2.display();
    }
}