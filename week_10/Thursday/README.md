**Note: this is just my personal summary of what we've covered this quarter. You should also focus on lecture's code snippets on Bruinlearn for review.**

# Pre-Midterm Part

Please refer to: https://github.com/g1n0st/PIC20A_24F_DIS1A/tree/master/week_6/Tuesday

# Extra NOTE:

###  Access Modifiers

| Class / Access Specifier | private | default | protected | public |
| --- | --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes | Yes |
| Same package | No  | Yes | Yes | Yes |
| Subclass outside of package | No  | No  | Yes | Yes |
| Unrelated class outside of package | No  | No  | No  | Yes |

A subclass can only override methods in the parent class that are visible to it. This includes: **protected**, **public**, or **package-private** and within the same package.

If a subclass defines a method with the same name, parameters, and return type as the parent class's private method, this is not overriding. Instead, the subclass defines a new, independent method that is unrelated to the parent’s private method, which is called hiding.

###  Overriding

``` Java
class Parent {
    protected void show() {
        System.out.println("Parent show method");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child show method");
    }
}
```

## Hiding

``` Java
class Parent {
    private void show() {
        System.out.println("Parent show method");
    }
}

class Child extends Parent {
    public void show() {
        System.out.println("Child show method");
    }
}
```

Static methods and fields can only be hidden, not overridden.

## `toString()`

Be careful when it is overridden. And you should be familiarize with its default behaviors, e.g., what happens when you print an array or a class by default.

# Post-Midterm Part

## super() Call in Constructors

If `super()` is not explicitly called, Java automatically inserts a no-argument `super()` call.

If super class no default constructor, missing calling `super()` will throw error

`super()` keyword also requires proper argument list to call.

## GUI

### JFrame & JPanel & JLabel & Layout Manager

Be familiarize with all the APIs like `setDefaultCloseOperation`, `add`, `setPreferredSize`, `setVisible`, `GridLayout(rows, cols)`, `repaint()` ...

The question type will not let you write APIs by hand, but will give you a specific code and let you determine the corresponding behavior (what will happen when you press certain button, what will be displayed on the screen, etc.)

### JButton

**ActionListener**: Must implement the `actionPerformed(ActionEvent e)` method to define what happens when the button is clicked.

**actionPerformed**: Contains logic for handling the event.

### Timer

`Timer` is used to perform an action repeatedly after a specified delay. The task to execute is specified using an `ActionListener`.

## Exception

**Try-Catch-Finally**

The try-catch-finally block is a fundamental construct in Java for handling exceptions. It allows developers to catch and handle exceptions that may occur within a specific block of code.

**Basic try-catch**

The basic structure of a try-catch block is as follows:

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

In this structure, the code within the try block is monitored for exceptions. If an exception occurs, it is caught by the catch block, where developers can provide the necessary code to handle the exception, such as logging an error message or taking corrective actions.

**Multiple catch blocks**

It is possible to catch different types of exceptions using multiple catch blocks:

```java
try {
    // Code that may throw an exception
} catch (ExceptionType1 e) {
    // Code to handle ExceptionType1
} catch (ExceptionType2 e) {
    // Code to handle ExceptionType2
}
```

By using multiple catch blocks, developers can handle different exceptions in a specific manner based on their types.

**The finally block**

The finally block is used to execute code that should always run, regardless of whether an exception occurs or not. It is typically used to release resources or perform cleanup operations. The finally block is placed after the catch block(s) and executes even if an exception is thrown or caught.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
} finally {
    // Code that always executes
}
```

The finally block ensures that critical cleanup tasks are performed, even if an exception occurs during the execution of the try or catch blocks.

**Throws and Throw**

The "throws" keyword is used in a method signature to declare that the method may throw a particular exception. It is typically used when a method cannot handle an exception itself and wants to pass the responsibility of handling to its caller.

```java
public void someMethod() throws SomeException {
    // Method implementation
}
```

On the other hand, the "throw" keyword is used to explicitly throw an exception within the code. This allows developers to create and propagate exceptions programmatically.

```java
throw new SomeException("Something went wrong.");
```