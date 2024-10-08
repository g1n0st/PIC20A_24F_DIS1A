class Test {
    static int count = 0;
    public static void fun()
    {
        System.out.println("Static Test.fun() called");
    }
}

class RightStaticTest {
    public static void main(String arr[])
    {
        System.out.println("Test.count = " + Test.count);
        Test.fun();
    }
}