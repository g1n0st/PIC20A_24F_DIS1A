# Objects and References

- **Object**: An instance created in heap memory using the new keyword containing data and behavior.

- **Reference**: A variable stored in stack memory that holds the address of an object in the heap, allowing indirect manipulation of the object.

### Reference Assignment and Object Sharing

- Assigning one object's reference to another variable means both references point to the same object.

- Modifying the object through one reference affects the other, as they share the same underlying object.

### Creating New Objects

- Each invocation of new creates a distinct object in heap memory.

- Even if two references initially point to the same object, assigning a new object to one reference does not impact the other; they will then point to different objects.

# Conversions
1. **Widening Conversion**: Converts a smaller data type to a larger one (e.g., int to long). This is implicit and does not lose data.

2. **Narrowing Conversion**: Converts a larger data type to a smaller one (e.g., double to float). This requires explicit casting and may lose data.

4. **Implicit Conversion**: This happens automatically when no data loss occurs, such as in widening conversions.

5. **Explicit Conversion**: Requires manual casting when there's a risk of data loss, such as in narrowing conversions.

6. **Upcasting**: Refers to casting a subclass object to a superclass type; this is implicit.

7. **Downcasting**: Converts a superclass reference back to a subclass type. This requires explicit casting and can throw ClassCastException if not compatible.

### Rules for automatic type promotion

The following rules for type promotion must be followed when executing expressions in Java to achieve correct results:

- All variables of the types `byte`, `short`, and `char` must be auto type promoted to `int`.

- If any variable taking part in an operation is `long`, the operation result must be `long`.

- If any variable taking part in an operation is `float`, the operation result must float.

# Overflow & Underflow

This behavior does not raise errors.

1. **Overflow**: When a value goes above the maximum limit of a data type, it wraps around to the minimum value. 

2. **Underflow**: Similarly, if a value falls below the minimum limit, it wraps around to the maximum.

3. **Truncation**: Truncation occurs when converting a larger data type to a smaller one, resulting in the loss of higher-order bits.

# Static Keyword
- Static member variables. 
   - They are shared by all instances.

- Static member functions.
  - They can only call other static methods and access static data members. 
  - To access non-static member variables/methods, you need to create a class instance first and then access them through that instance.

- Both static data members and static methods can be accessed without creating an object. They can be accessed using the class names like `Test.func()`.

# Overloading

In Java, we do method overloading in two ways:

- By changing the number of parameters.
- By changing data types.

If the **only** difference between the two methods is the return type, the Java compiler cannot distinguish between them and will report an error.

# Constructors

1. **Default Constructor**: provided by the Java compiler by default, will be disabled if other constructor functions are provided. It takes no parameters and initializes fields to default values.

2. **Copy Constructor**: will copy and create a new instance.

3. **Chained Constructors** (Constructor Chaining): use the `this` keyword to call other constructor methods.

4. **Private Constructor**: used to prevent the instantiation of a class. Call it will throw an error.

# Final

1. When applied to a variable (field), the `final` keyword indicates that the variable's value **cannot be changed** after it is initially assigned. It effectively makes the variable a constant. Change it will throw an error.

2. A final class in Java is a class that cannot be extended. No other class can inherit from a final class.

3. Final methods in Java are methods that cannot be overridden by subclasses.


# Access Modifiers

Elements with no access modifier are only accessible within the same package.

| Class / Access Specifier | private | default (package - private) | public |
| --- | --- | --- | --- |
| same Class | Yes | Yes | Yes |
| different Class, but same package | No  | Yes | Yes |
| different Class, different package | No  | No  | Yes |


- `Yes` indicates that the class is accessible with the access specifier.

- `No` indicates that the class with the access specifier is inaccessible.

# Inheritance and Polymorphism

With upcasting, the superclass reference can only call the methods defined in the superclass.

When you use that base class object to call a method, if that method is overridden, then **always** the overridden method is called.