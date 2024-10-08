public class PuzzleOverloading {
    public void print(double x, double y, double z) {
        System.out.println("double: " + x + ", double: " + y + ", double: " + z);
    }

    public void print(double x, int y, int z) {
        System.out.println("double: " + x + ", int: " + y + ", int: " + z);
    }
    
    // what if we remove the last two print functions?
    public void print(double x, int y, char z) {
        System.out.println("double: " + x + ", int: " + y + ", char: " + z);
    }

    public void print(double x, double y, char z) {
        System.out.println("double: " + x + ", double: " + y + ", char: " + z);
    }

    public static void main(String[] args) {
        PuzzleOverloading puzzle = new PuzzleOverloading();
    
    	puzzle.print(10.0, 1.5, 'c');
        puzzle.print(10.0, 1, 'c');
    }
}