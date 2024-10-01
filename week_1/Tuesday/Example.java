public class Example {
    public static void main(String[] args) {
        System.out.println("This is the main class.");
        Helper.displayMessage();
        Utility.printNumber(42);
    }
}

class Helper {
    public static void displayMessage() {
        System.out.println("This is the helper class.");
    }
}

class Utility {
    public static void printNumber(int number) {
        System.out.println("Utility class received number: " + number);
    }
}