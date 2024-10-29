# Inheritance

Inheritance is a mechanism in Java that allows one class (the child or subclass) to inherit the properties and behaviors (fields and methods) of another class (the parent or superclass). Inheritance promotes code reuse and the creation of a hierarchy of classes.

```Java
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); // Call the constructor of the baseclass, which has to be the first statement
    }

    public void bark() {
        System.out.println(name + " is barking.");
    }
}
```

In this example, `Dog` is a subclass of `Animal`. It inherits the `name` field and `eat` method from `Animal`. This means you can create `Dog` objects and call `eat` on them, even though `eat` is defined in the `Animal` class.

```Java
Dog dog = new Dog("Buddy");
dog.eat(); // Calls the eat method from the Animal class
dog.bark(); // Calls the bark method from the Dog class
```

## Summary

1. Inheritance allows classes to inherit properties(fields) and behaviors(methods) from other classes, creating a hierarchy of classes. This allows different classes to share the same method implementation and data member names, which **avoids code duplication.**
2. All the public, private, and default methods/fields will be inherited by the child class. However, within the child class, you cannot access the private methods/fields defined in the parent class.
3. Within the child class, you can not only define additional methods/fields but also **override** the methods that are originally defined in the parent class.

# Polymorphism

Polymorphism means "many forms", and is a concept in which objects of different classes are treated as objects of a common superclass. It allows you to use a single interface to represent different classes.

```Java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}
```

In this example, `Dog` and `Cat` both inherit from `Animal` and override the `makeSound` method. Using polymorphism, you can create an array of `Animal` objects and call `makeSound` on each object, which will execute the appropriate implementation based on the actual object type.

```Java
Animal[] animals = new Animal[3];
animals[0] = new Animal();
animals[1] = new Cat();
animals[2] = new Dog();

for (Animal animal : animals) {
    animal.makeSound(); // Calls the appropriate makeSound method for each object
}
```

Output:

```Java
Some sound
Meow
Bark
```

In this example, polymorphism allows you to treat objects of different subclasses as objects of the common superclass (`Animal`). The actual method that is called at runtime depends on the type of the object, demonstrating the power of polymorphism.

**Upcasting** is when a subclass object is assigned to a superclass reference variable.

```Java
Parent p = new Child(); // Upcasting is fine!
```

- Note that with upcasting, the superclass reference can only call the methods defined in the superclass, and any method that was overridden will call the overridden version defined in the subclass instead of the methods in the superclass. Note that it cannot call the methods defined in the subclass object even though it is pointing to it (unless it is an overridden method).
- This similar to **widening conversion**.

**Downcasting** is when a superclass reference variable is assigned to a subclass reference variable.

- Downcasting in the actual meaning of the word is not directly allowed. I.e.: subclass class ref points to superclass object - This is **not allowed**!!
- This is similar to **narrowing conversion**.

```Java
Child c = new Parent(); // This is NOT ALLOWED!!
```

- But, if we upcast first (i.e., make a superclass ref point to a subclass object) and then downcast (i.e., make a subclass ref point to the casted version) - Then it is okay!

```Java
Parent p = new Child(); // Upcast first
Child c = (Child)p; // And then downcast
// This is essentially making a Child ref point to a Child object anyway
```

## Summary

1.  **Upcasting**: a subclass/child class object is assigned to a superclass/parent class reference variable. Upcasting is always valid.
2.  **Downcasting**: a superclass/parent class object/reference variable is assigned to a subclass/ child class reference variable. Downcasting is not always allowed.
3. When you use that base class object to call a method, if that method is overridden, then the **overridden** method is called. 

# Factory Method

It is usually a public static method in a class responsible for creating and returning instances of that class or its subclasses based on a set of provided parameters or conditions. The Factory Method design pattern promotes loose coupling and flexibility in object creation by allowing the choice of which class to instantiate to be made at runtime. 

```Java
class Fruit {
    public void note() {}
}

class Apple extends Fruit {
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
```

# Summary

In conclusion, **inheritance** allows classes to inherit properties and behaviors from other classes, creating a hierarchy of classes. **Polymorphism** allows objects of different classes to be treated as objects of a common superclass, enabling dynamic method invocation based on the actual object type.