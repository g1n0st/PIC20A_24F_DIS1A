# Static Keyword

### Static Data Members

Static data members in Java are class members that shared among all objects. For example, in the following Java program, the static variable `count` is used to count the number of objects created.

``` Java
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
```

**Output:**

```
Total 3 objects created
```

### Static Member Methods

In Java, static member functions can be defined. Methods declared as static are class members and have the following restrictions:

1.  They can only call other static methods. For example, the following program fails in the compilation. `fun()` is non-static and it is called in static `main()`.

``` Java
class ErrorStaticTest {
    public static void main(String args[])
    {
        System.out.println(fun());
    }
    int fun() { return 20; }
}
```

**Error:**

```
Cannot make a static reference to the non-static method fun() from the type ErrorStaticTest
```

2.  They must only access static data.
3.  They cannot access the `this` pointer.
4.  Static data members and static methods can be accessed without creating an object. They can be accessed using the class names. For example, in the following program, static data member `count` and static method `fun()` are accessed without any object.

``` Java
class Test {
    static int count = 0;
    public static void fun()
    {
        System.out.println("Static Test.fun() called");
    }
}

class RightStaticTest {
    public static void main(String arr[])
    {
        System.out.println("Test.count = " + Test.count);
        Test.fun();
    }
}
```

**Output:**

```
Test.count = 0
Static fun() called
```

### Static Keyword Summary

- Static member variables. Declared and stored in memory even before the main function. They are **shared by all instances**. They won't be destroyed as long as the program is still running.
- Static member functions.
    - They can **only** call other static methods and access static data members. To access non-static member variables/methods, you need to create a class instance first and then access them through that instance.
    - Both static data members and static methods can be accessed **without** creating an object. They can be accessed using the class names like `Test.func()`.

# Math

Math is a utility class contains a set of common and reused members. Below is a example of `sin()` function

``` Java
public class SinTest {
  public static void main(String[] args) {
    System.out.println(Math.sin(0.1)); 
  }
}
```

**Quick question:** Is this `sin()` method static or non-static?

Full APIs of Math: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html

# Overloading

Method overloading is a feature of Java in which a class has more than one method of the **same name** but their **parameters are different**. In other words, we can say that method overloading is a concept of Java in which we can create multiple methods of the same name in the same class, but all methods work in different ways. When more than one method of the same name is created in a Class, this type of method is called the **Overloaded Method**. 

**NOTE: method overloading has nothing to do with return-type**. If the only difference between two methods is the return type, the Java compiler cannot distinguish between them and will report an error.

In Java, we do method overloading in two ways:

1.  By changing the number of parameters.
2.  By changing data types.

Here's an example of method overloading in Java:

``` Java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

In this example, we have three overloaded `add` methods in the `Calculator` class. They have the same name but different parameter lists (number and type of parameters). You can use these methods to perform addition with integers or double values, and the appropriate method will be called based on the arguments you provide.

However, overloading can lead to **ambiguity** when the compiler cannot determine which overloaded method to call based on the provided arguments. This happens when the overloaded methods have parameter lists that are too similar, making it impossible for the compiler to distinguish between them. Here's an example of overloading leading to ambiguity:

``` Java
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
```

**Error:**

```
Duplicate method add(int, int) in type AmbiguousOverloading
```

This results in ambiguity because when you call `calculator.add(5, 7)`, the compiler cannot determine whether you intend to call `add(int a, int b)` or the ambiguous `add(int x, int y)` method

**Open question:** What is the benefit of overloading?

### Exercise:

What is the output of the following code? What if we remove the last two print functions (`print(double x, int y, char z)` and `print(double x, double y, char z)`? (Hint: implicit conversion)

``` Java
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
```

## Conversions

In Java we have two types of conversion techniques:

- explicit conversion/casting: usually done by putting data type in front of variables/values
    
    - e.g. `double d = ((double) 1) / ((double) 2);`
- implicit conversion/casting: this happens when doing arithmetic among mixed types.
    
    - e.g. `double d = 5;`, `'a' + 1`
    - the order of implicit conversion

![conversion.png](./_resources/conversion.png)

In implicit conversion, widening conversion is automatic, but narrowing conversion is not (compilation errors). Though narrowing conversion is allowed in explicit conversion in terms of grammar, it may lead to unexpected behaviors due to underflow/overflow.

### Exercise:

``` Java
public class DoubleConversion {
    public static void main(String[] args) {
        double x = 12345.1234512345123451234512345;
        float y = (float) x;
        System.out.println("double value: " + x);
        System.out.println("float value: " + y);
    }
}
```

``` Java
public class DecimalToIntConversion {
    public static void main(String[] args) {
        double x1 = 9.99;
        System.out.println((int) x1);
        double x2 = 1.01;
        System.out.println((int) x2);
        double x3 = -9.99;
        System.out.println((int) x3);
        double x4 = -1.01;
        System.out.println((int) x4);
    }
}
```

``` Java
public class IntegerNarrowingConversion {
    public static void main(String[] args) {
        long longValue = 12345678901L;
        int intValue = (int) longValue;
        System.out.println("long value: " + longValue);
        System.out.println("int value: " + intValue);

        int anotherInt = 10000;
        short shortValue = (short) anotherInt;
        System.out.println("int value: " + anotherInt);
        System.out.println("short value: " + shortValue);
    }
}
```
