class StaticDataTest {
    static int count = 0;

    StaticDataTest() { count++; }
    public static void main(String arr[]) {
        StaticDataTest t1 = new StaticDataTest();
        StaticDataTest t2 = new StaticDataTest();
        StaticDataTest t3 = new StaticDataTest();
        System.out.println("Total " + StaticDataTest.count
                        + " objects created");
    }
}