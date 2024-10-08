public class AmbiguousOverloading {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Attempted overloaded method with the same parameter types (ambiguity)
    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        AmbiguousOverloading calculator = new AmbiguousOverloading();
        
        // The following line will lead to a compilation error due to ambiguity.
        int result = calculator.add(5, 7);
        System.out.println(result);
    }
}