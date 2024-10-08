public class DecimalToIntConversion {
    public static void main(String[] args) {
        double x1 = 9.99;
        System.out.println((int) x1); // Fraction is discarded
        double x2 = 1.01;
        System.out.println((int) x2); // Fraction is discarded
        double x3 = -9.99;
        System.out.println((int) x3); // Fraction is discarded
        double x4 = -1.01;
        System.out.println((int) x4); // Fraction is discarded
    }
}