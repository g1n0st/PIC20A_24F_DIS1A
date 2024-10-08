public class DoubleConversion {
    public static void main(String[] args) {
        double x = 12345.1234512345123451234512345; // A very precise number, computer cannot store it!!
        float y = (float) x;  // Narrowing conversion
        System.out.println("double value: " + x); // Loss of precision
        System.out.println("float value: " + y);  // Loss of more precision
    }
}