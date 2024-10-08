public class IntegerNarrowingConversion {
    public static void main(String[] args) {
        long longValue = 12345678901L; // use L-suffix to define long-type literal
        int intValue = (int) longValue;  // Narrowing conversion
        System.out.println("long value: " + longValue);
        System.out.println("int value: " + intValue);  // Overflow

        int anotherInt = 10000;
        short shortValue = (short) anotherInt;  // Narrowing conversion
        System.out.println("int value: " + anotherInt);
        System.out.println("short value: " + shortValue);  // No overflow in this case
    }
}