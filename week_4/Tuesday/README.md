# Review of Java Classes

A class is a blueprint or template for creating objects with fields and methods.

**Fields (Data Members):** Fields are variables declared within a class that hold data or state for objects of that class. Fields define the characteristics or attributes of objects. You can access an object's field like `object.data` (if `data` is a public field)

**Methods:** Methods are functions defined within a class that represent the behavior or actions of objects. Methods perform tasks or operations on the object's data. You can call an object's method like `object.method()` (if `method()` is a public method)

**Access Control**: Methods can also have access modifiers to control their visibility and accessibility. Public fields/methods can be accesses from anywhere while private fields/methods can only be accessed within the class scope

**Non-static/static:** Non-static fields belong to individual instances (objects) of the class whileStatic fields are associated with the class itself rather than with specific instances (objects) of the class. Static fields/methods can be accesses without initializing any object while non-static fields/methods have to be accessed via object instances.

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

# Summary of Constructors

In Java, constructors are special methods used for initializing objects when they are created from a class. Constructors have the same name as the class and are used to set the initial state of an object.

**1\. Default Constructor:** a default constructor is provided by the Java compiler if a class does not explicitly define any constructors. It takes no parameters and initializes fields to default values (e.g., 0 for numeric types, `null` for reference types). The default constructor will be **disabled** if other constructor functions are provided.

```Java
public class Student {
    public String name;
    public int age;

    public static void main(String[] string)
    {
    	// name will initialized to null
    	// age will be initialized to 0
        Person p1 = new Student();
    }
}
```

**2\. Parameterized Constructor:** a parameterized constructor is a constructor that accepts one or more parameters, allowing you to pass values to initialize object fields.

```Java
public class Student {
    public String name;
    public int age;

    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

**3\. Overloaded Constructors:** a class can have multiple constructors with different parameter lists. This is called constructor overloading. You can create constructors with different parameter combinations to provide flexibility when creating objects.

```java
public class Student {
    public String name;
    public int age;

    // Constructor with name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor with only name
    public Student(String name) {
        this.name = name;
        this.age = 18;
    }
}
```

**4\. Copy Constructor:** A copy constructor is used to create a new object that is a copy of an existing object of the same class. It is often used for creating deep copies of objects to avoid sharing references to the same data.

```Java
public class Student {
    public String name;
    public int age;

    // Copy constructor
    public Student(Student otherStudent) {
        this.name = otherStudent.name;
        this.age = otherStudent.age;
    }
}
```

**5\. Chained Constructors (Constructor Chaining):** Chained constructors allow one constructor to call another constructor of the same class. This is useful when you want to reuse code for common initialization tasks.

```Java
public class Student {
    public String name;
    public int age;

    // Constructor with name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor with only name
    public Student(String name) {
        this(name, 18);
    }
}
```

**6\. Private Constructor:** A private constructor is used to prevent the instantiation of a class. It is often used in utility classes where objects should not be created.

```Java
public class UtilityClass {
    private UtilityClass() {
        // disable constructors
    }
}
```

# Final Variables

When applied to a variable (field), the `final` keyword indicates that the variable's value **cannot be changed** after it is initially assigned. It effectively makes the variable a constant.

```Java
public class Circle {
    public final double PI = 3.14159265359; // A final constant field
}
```

Note the final fields must be assigned a value when it is declared or in a constructor.

When you declare an object reference as `final`, you are preventing the reference from pointing to a different object. The reference will always point to the same object throughout its lifetime. But you are allowed to modify its data members as long as they are not `final` data members.

```Java
public class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] strings)
    {
        final Student s1 = new Student("Eric", 18);

        // you can't change the reference value of s1
        // s1 = new Student("Bob", 20);

        // but you can change the non-final data members of a final object instance
        s1.age = 21;
    }
}
```

# Exercise

Write a class `PositionedCircle` that extends the provided `Circle` class. 

The new class should include two additional fields, `x` and `y`, which represent the position of the circle on a 2D plane. 

`(x, y)` fields should be initialized to `(0, 0)` if not provided. 

The class should include a method `inside(double x0, double y0)` that returns `true` if the point `(x0, y0)` lies inside the circle (on or within the perimeter), and `false` otherwise.

The class should also include a static method `overlap(PositionedCircle c1, PositionedCircle c2)` that returns `true` if two `PositionedCircle` objects overlap (their perimeters touch or intersect), and `false` otherwise.

```java
class PositionedCircle {
    // Write your code here ...
}

public class PositionedCircleTester {
    public static void main(String[] args) {
        // Test default constructor
        PositionedCircle circle1 = new PositionedCircle();
        System.out.println("Default constructor:");
        System.out.println("x: " + circle1.x + ", y: " + circle1.y + ", radius: " + circle1.radius);

        // Test parameterized constructor
        PositionedCircle circle2 = new PositionedCircle(5.0, 3.0, 4.0);
        System.out.println("\nParameterized constructor:");
        System.out.println("x: " + circle2.x + ", y: " + circle2.y + ", radius: " + circle2.radius);

        // Test overloaded constructor
        PositionedCircle circle3 = new PositionedCircle(10.0);
        System.out.println("\nOverloaded constructor:");
        System.out.println("x: " + circle3.x + ", y: " + circle3.y + ", radius: " + circle3.radius);

        // Test inside method
        boolean isInside = circle2.inside(4.0, 5.0);
        System.out.println("\nInside method test:");
        System.out.println("Point (4.0, 5.0) inside circle2: " + isInside);

        // Test overlap method
        boolean isOverlap = PositionedCircle.overlap(circle2, circle3);
        System.out.println("\nOverlap method test:");
        System.out.println("Circle2 overlaps with circle3: " + isOverlap);
    }
}
```