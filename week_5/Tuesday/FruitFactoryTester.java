class Fruit {
    public void note() {}
}

class Apple extends Fruit {
    @Override
    public void note() {
        System.out.println("You bought an Apple");
    }
}

class Banana extends Fruit {
    public void note() {
        System.out.println("You bought a Banana");
    }
}

class Orange extends Fruit {
    public void note() {
        System.out.println("You bought an Orange");
    }
}

class FruitFactory {
    public static Fruit createFruit(String fruitName) {
        switch (fruitName.toLowerCase()) {
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "orange":
                return new Orange();
            default:
                throw new IllegalArgumentException("Unknown fruit type: " + fruitName);
        }
    }
}

public class FruitFactoryTester {
    public static void main(String[] args) {
        FruitFactory.createFruit("apple").note();
        FruitFactory.createFruit("banana").note();
        FruitFactory.createFruit("orange").note();
    }
}
