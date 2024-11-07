# Override Keyword

The `@Override` annotation in Java is a powerful tool used to indicate that a method is intended to override a method declared in a superclass. Some key points:

- **Compile-Time Check**When annotating a method with `@Override`, the compiler checks to ensure that the method is overriding a method from a superclass or implementing an abstract method from an interface. If it isn't, the compiler throws an error.
- **Readability and Clarity**: It makes your code more readable and understandable. It clearly communicates to anyone reading the code that the method is meant to override a method from a superclass or implement an interface method.

Note a private method **cannot be** overridden in a subclass. This is because private methods are not visible to subclasses.

# Abstract Class and Interface

## Abstract Class

An abstract class in Java is a class that cannot be instantiated, meaning you cannot create objects of an abstract class. It is used as a base for other classes. It can include abstract methods (methods without a body) as well as concrete methods (methods with a body).

## Interface

**Multiple Inheritance of Behavior**: Java does not support multiple inheritances of state (i.e., extending multiple classes) due to ambiguity issues (like the Diamond Problem). However, interfaces allow multiple inheritances of behavior, as a class can implement multiple interfaces.

## Comparison with Abstract Class

1.  **Method Implementation**: Abstract classes can have a mix of fully implemented (concrete) methods and abstract methods. Traditionally, interfaces could only have abstract methods, but with Java 8, they can also have default and static methods with implementations.
    
2.  **State Holding**: Abstract classes can have instance variables and thus hold a state. Interfaces cannot hold a state (they can only have static final variables).
    
3.  **Multiple Inheritance**: A class can implement multiple interfaces, thereby inheriting multiple behaviors. However, a class can extend only one abstract class due to Java's restriction on single inheritance for classes.
    
4.  **Constructor**: Abstract classes can have constructors. Interfaces cannot have constructors as they cannot be instantiated.
    
5.  **Accessibility Modifiers**: Methods in an interface are implicitly public. Abstract classes can have methods with various access modifiers (public, protected, private).
    
6.  **Usage Scenario**: Use an abstract class when creating a class hierarchy that shares a common state and behavior. Use an interface when different classes from different hierarchies need to share a contract for behaviors.