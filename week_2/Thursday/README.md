# Control Flow & Loops

## Control Flow Structures

**1\. Conditional Statements (if, else if, else):** conditional statements allow you to execute code based on certain conditions.

``` Java
int num = 10;
if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

Conditional statements can be combined with logical operators like `&&` (AND) and `||` (OR) to create more complex conditions. For instance, you can check if a number is within a specific range: `if (num > 0 && num < 100)`. Also, remember that conditions are evaluated in order; once a true condition is found, the remaining else-if blocks are skipped. This mechanism allows for efficient decision-making in your code.

**2\. Switch Statement:** the switch statement is used to select one of many code blocks to be executed.

``` Java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    // ...
    default:
        System.out.println("Invalid day");
}
```

In a switch statement, if you forget the `break`, the code will "fall through" and execute the code in the next case as well. This can be used intentionally in some designs, but it's often a source of bugs!

One advantage of using a `switch` statement over multiple `if-else-if` conditions is improved readability and maintainability when dealing with a variable that can have many specific values. The switch statement provides a clear, organized structure for handling multiple possible cases based on the same variable, making the code easier to read and manage. Additionally, in some scenarios, `switch` statements can offer better performance because they may be optimized by the compiler to use a **jump table**, allowing for faster execution compared to evaluating multiple `if-else` conditions sequentially.

## Loop Structures:

**1.while Loop:** the while loop executes a block of code as long as a condition is true.

``` Java
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;
}
```

Be careful with the condition! If you accidentally set up a condition that never becomes false, you’ll create an **infinite loop**—meaning the program will run forever (or until you stop it). This is common when forgetting to update the loop variable.

**2\. do-while Loop:** the do-while loop is similar to the while loop, but it guarantees that the block of code is executed at least once.

``` Java
int count = 1;
do {
    System.out.println("Count: " + count);
    count++;
} while (count <= 5);
```

The main difference between a `while` and a `do-while` loop is that the `do-while` loop will always run at least once, even if the condition is false from the start. This is useful when you need a block of code to run before checking conditions, such as asking for user input.

**3\. for Loop:** the for loop provides a concise way to iterate over a range of values.

``` Java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

The for loop's structure—initialization, condition, and update—makes it powerful for controlled iterations. It's not limited to incrementing; you can decrement or change the loop variable in any way, such as `for (int i = 5; i > 0; i--)`. Be mindful of "off-by-one" errors by carefully setting your loop's starting point and termination condition.

**4\. Enhanced for (for-each) Loop:** the enhanced for loop is used to iterate through arrays or collections.

``` Java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

One of the advantages of the enhanced for-loop is that it is simpler and more concise than the basic for-loop, especially when you are iterating over all the elements of an array. However, it has some limitations. For example, you cannot use the enhanced for-loop to modify the elements of an array, as it only provides read-only access to the elements. You also cannot use the enhanced for-loop to iterate over a range of indexes in an array, as it does not provide access to the index of the current element.

While the enhanced for loop simplifies iteration, it doesn't allow access to the index of each element. If you need to know the position of an element or modify elements in the array, a traditional for loop is more appropriate.