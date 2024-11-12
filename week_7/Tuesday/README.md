# Constructor Chaining

Constructor chaining occurs when one constructor calls another constructor in the same class or in the superclass. It allows the class to reuse code and initialize objects in steps.

- **Within the same class**, this is done using `this(parameters...)`.

- **Across classes (superclass to subclass)**, chaining is achieved with `super(parameters...)`.
This is helpful to avoid repeating code across multiple constructors by creating a single initialization path.

## `super()` Call in Constructors

The `super()` keyword in a subclass constructor calls the constructor of the superclass (parent class). This is useful when you want to initialize fields or perform setup defined in the superclass before customizing with subclass-specific initialization.

- If `super()` is not explicitly called, Java automatically inserts a no-argument `super()` call, assuming there’s a no-argument constructor in the superclass.

**NOTE:**  If super class no default constructor, missing calling `super()` will throw error: Implicit super constructor is undefined. Must explicitly invoke another constructor

``` Java
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called with name: " + name);
    }
}

class Dog extends Animal {
    Dog() {
        // Implicit call to `super()` here, but no default constructor in `Animal`
        System.out.println("Dog constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();  // This will cause a compile-time error
    }
}
```

## Key Points
- **Order of Initialization**: The superclass constructor is always executed first to ensure that the parent class setup is complete before the subclass adds its specifics.

- **Single Call Rule**: Only one `super()` or `this()` call is allowed as the first line in any constructor to avoid ambiguity.

- **Purpose**: Constructor chaining simplifies initialization logic and reduces redundancy by allowing constructors to delegate tasks among each other.

# `instanceof` Keyword

The `instanceof` keyword in Java is used to check whether an object is an instance of a specific class or a subclass. It helps determine the actual type of an object at runtime, which is useful when working with polymorphism or when casting objects safely.

## Syntax and Usage

``` Java
if (object instanceof ClassName) {
    // Code to execute if object is an instance of ClassName
}
```

## Key Points

- **Type Checking**: `instanceof` is helpful when you need to check an object's type before casting it.

- **Null Safety**: If the object being tested is `null`, `instanceof` returns false, making it null-safe.

- **Polymorphism Support**: It’s especially useful in polymorphic code where an object’s exact type isn’t known at compile-time.

## Example of `instanceof`

``` Java
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Dog() };

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                System.out.println("This is a Dog.");
            } else if (animal instanceof Cat) {
                System.out.println("This is a Cat.");
            } else {
                System.out.println("Unknown animal.");
            }
        }
    }
}
```

## When instanceof Cannot Be Used (and Will Throw an Error)

If you attempt to use `instanceof` to check an object against a class with no inheritance or interface relationship, the compiler will throw an incompatible conditional operand types error.

``` Java
class Dog {}
class Cat {}

Dog dog = new Dog();
if (dog instanceof Cat) { // Compile-time error: Incompatible conditional operand types Dog and Cat
    System.out.println("This is a Cat.");
}
```

# `Object` as the Superclass of All Classes

- In Java, `Object` is the root of the class hierarchy. Every class directly or indirectly inherits from `Object`.

- This means that an `Object` reference can hold an instance of any class.

``` Java
Object obj = new String("Hello, World!");
System.out.println(obj);  // Output: Hello, World!
```

The Object class provides a few methods that every Java class inherits. Key methods include:

- **toString()**: Returns a string representation of the object.
- **equals(Object obj)**: Checks if two objects are equal based on their content, not their memory addresses.
- **hashCode()**: Returns a hash code value for the object, which is used in hash-based collections like HashMap.
- **getClass()**: Returns the runtime class of the object.
- **clone()**: Creates and returns a copy of the object (requires implementing Cloneable interface).

## `clone()`

- If an object implements the `Cloneable` interface, it can create a copy of itself using clone(). 

**NOTE:** if not implements from `Cloneable`, calling `clone()` will throw a `CloneNotSupportedException` runtime exception.

By default, this method performs a shallow copy:

``` Java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;  // Reference to an Address object

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Performs a shallow copy
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Address address = new Address("New York");
            Person original = new Person("Alice", address);
            Person copy = (Person) original.clone();

            // Modify the address of the cloned object
            copy.address.city = "Los Angeles";
            copy.name = "Bob";

            System.out.println("original.name=" + original.name);
            System.out.println("copy.name=" + copy.name);

            System.out.println("original.address.city=" + original.address.city);
            System.out.println("copy.address.city=" + copy.address.city);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```

Output:

```
Original person's name: Alice
Original person's city: Los Angeles
Cloned person's name: Bob
Cloned person's city: Los Angeles
```

The `name` field is a `String` (which is immutable), so changing the name in the clone doesn't affect the original.

- In Java, an immutable object is one whose state or content cannot be modified after it is created. The String class is an example of an immutable class, meaning that once a String object is created, its value cannot be changed. Any "modification" on a String (such as concatenation, substring extraction, or replacement) actually results in the creation of a new String object, rather than altering the original object.

``` Java
String s1 = "Hello";
String s2 = s1;
s1 = "World";
System.out.println(s2);  // Output is still "Hello"
```

The `address` field is a reference to an `Address` object. Both original and copy point to the **same `Address` instance**.

### Corrected Version

To implement a deep copy, where all referenced objects are also copied, you need to override `clone()` carefully, often recursively calling `clone()` on contained objects.

``` Java
@Override
protected Object clone() throws CloneNotSupportedException {
    Person cloned = (Person) super.clone();      // Shallow copy of Person
    cloned.address = (Address) address.clone();  // Deep copy of Address
    return cloned;
}
```

# Comprehensive Example

``` Java
interface Animal{
    public void run();
    public void sleep();
    public void food();
    public void sound();
    public void whereFrom();
}

interface Pet{
    public void furColor();
    public String favoritePetToy();
    public void feature();
}

abstract class Cat implements Animal, Pet {

    public String name;

    public Cat(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("A cat is chasing a mouse.");
    }

    public void sleep(){
        System.out.println("Cats usually sleep between 12 and 18 hours a day.");
    }

    public void food(){
        System.out.println("Fish");
    }

    public void sound(){
        System.out.println("Meow");
    }

    public String favoritePetToy(){
        return "yarn ball";
    }
}

abstract class Dog implements Animal, Pet {

    public String name;

    public Dog(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("A dog is chasing a frisbee.");
    }

    public void sleep(){
        System.out.println("Dogs usually sleep between 12 and 14 hours a day.");
    }

    public void food(){
        System.out.println("Bones");
    }

    public void sound(){
        System.out.println("Woof");
    }

    public String favoritePetToy(){
        return "frisbee";
    }
}

class PersianCat extends Cat implements Pet {

    public int age;

    public PersianCat(int age, String name){
        super(name);
        this.age = age;
    }

    public String toString(){
        return "(Persian cat) Name: " + name + ", Age: " + age;
    }

    public void furColor(){
        System.out.println("Many different colors.");
    }

    public void whereFrom(){
        System.out.println("Khorasan (eastern region in the Iranian Plateau).");
        
    }

    public void feature(){
        System.out.println("Long-haired");
    }
}

class Samoyed extends Dog implements Pet{

    public int age;

    public Samoyed(int age, String name){
        super(name);
        this.age = age;
    }

    public String toString(){
        return "(Samoyed) Name: " + name + ", Age: " + age;
    }

    @Override
    public void sound(){
        System.out.println("Woof Woof!");
    }

    public void furColor(){
        System.out.println("White.");
    }

    public void whereFrom(){
        System.out.println("Siberia.");
        
    }

    public void feature(){
        System.out.println("Always smiling.");
    }

    public void nameOrigin(){
        System.out.println("Samoyed dog takes its name from the Samoyedic peoples of Siberia");
    }
}

public class Test{
    public static void main(String[] args){
        
        PersianCat myKitten = new PersianCat(2, "Kitten");
        Samoyed myPuppy = new Samoyed(4, "Puppy");
        
        Animal[] listOfAnimals = new Animal[] {myKitten, myPuppy};
        
        Cat cat = myKitten;
        Dog dog = myPuppy;

        Pet[] listOfPets = new Pet[] {myKitten, myPuppy};

        System.out.println(myKitten);
        System.out.println(myPuppy);

        // You may check the topic on "Object class" for the reason
        // why you can call toString method which seems not defined 
        // in Cat or Dog classes.
        System.out.println(cat);
        System.out.println(dog);

        cat.sound();
        dog.sound();

        // dog.nameOrigin();  // cannot call

        ((Samoyed) dog).nameOrigin();

        listOfAnimals[0].whereFrom();
        listOfAnimals[1].whereFrom();

        // listOfAnimals[0].furcolor();  // cannot call
        // listOfAnimals[1].furcolor();  // cannot call
    }
}
```