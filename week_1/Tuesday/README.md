# Usage of VSCode

Visual Studio Code (VSCode) is a popular, lightweight, and powerful source code editor developed by Microsoft. It's widely used for programming across various languages and platforms.

1.  **User Interface Overview**:
    
    - **Activity Bar**: Located on the far left side, it allows you to switch between views like Explorer, Search, Source Control, and Extensions.
    - **Sidebar**: Displays different panels like file explorer, search results, source control, and more, based on what's selected in the Activity Bar.
    - **Editor Window**: The central area where you write and edit your code.
    - **Status Bar**: Located at the bottom, it shows information about the opened project and files.
2.  **Opening a Project**:
    - You can open a project by going to `File` \> `Open Folder` and selecting your project directory.
    - Files and folders in the project will be displayed in the Explorer panel.
3.  **Editing Code**:
    
    - Click on a file in the Explorer to open it in the editor.
        
    - VS Code supports syntax highlighting, intelligent code completion (IntelliSense), snippets, and refactoring.
        
    - Save your modification after you finish it
        
4.  **Keyboard Shortcuts**:
    
    - Learn useful shortcuts to enhance productivity. Access them via `Help` \> `Keyboard Shortcut Reference`.

5.  **Integrated Terminal**:
    
    - Access the integrated terminal via `View` \> `Terminal`. It's useful for running shell commands, Git commands, scripts, and more directly within VS Code.

    - I recommend running commands in the VSCode integrated terminal instead of exterior terminals. Some existing problems, including the Java environment, may not be set up correctly in exterior terminals, and you may need to use the `cd` command to change your work directory manually. Also, you don't have to switch windows between coding and compiling. : )

# Shell Command

A shell is a special user program that provides an interface to the user to use operating system services. Shell accepts human-readable commands from the user and converts them into something which the kernel can understand. It is a command language interpreter that executes commands read from input devices such as keyboards or from files.

Check out more shell commands:

- Linux/Mac OS: https://www.geeksforgeeks.org/basic-shell-commands-in-linux/
- Windows: https://www.stationx.net/windows-command-line-cheat-sheet/

You don't have to remember all these shell commands, but it's good to keep those frequently used commands in your mind.

For Windows, we have two terminals:

- **Command Prompt**: also known as cmd.exe, is a continuation of the MS-DOS command line used for executing traditional DOS commands and batch scripts. It has existed since the early versions of Windows. The command set is relatively simple, with syntax similar to MS-DOS, and commands are usually in abbreviated forms like dir and copy. 

- **PowerShell**: a more powerful command-line interface and scripting language developed by Microsoft, designed to replace the traditional Command Prompt and provide more advanced system management and automation capabilities.

They have different syntaxes (e.g., To show contents in PowerShell is `ls` but in Command Prompt is `dir`). I personally recommend using **PowerShell**. Its functionality is more powerful, and it has more online resources.

## File Path

### Basics

- File paths identify an unique single **file** or **directory** on your machine
- There are two kinds of paths: **relative path** and **absolute path**
- Relative paths can start with a name (`foo.txt` or `data/foo.txt`(mac/linux) or `data\foo.txt`(windows)). They are specified in relation to the *current working directory*
- There are two special names to start relative paths:
    - `./foo.txt or ./dir/foo.txt` or `.\foo.txt`: `.` means “the current directory”
    - `../foo.txt` or `../../dir/foo.txt or ..\foo.txt`: `..` means “the parent directory”
- Absolute paths start with a `/` (Mac/Linux) or a drive letter like `C:\` (Windows)
    - `/Users/yourname/Documents/foo.txt` (Mac/Linux)
    - `C:\Users\yourname\Documents\foo.txt` (Windows)
- Many commands take files as arguments using this syntax

### Current Directory

- Your command shell (like all programs) has a “current directory” variable
- Relative paths are interpreted starting at the current directory
- The current directory is typically shown in your shell prompt
    - `/Users/yourname/Documents $` or `C:\Users\yourname\Documents >`
    - You may also print it using `pwd` command
- Change the current directory with the `cd` (Mac/Linux/Windows)
    - `cd pic20a` or `cd /Users/yourname/pic20a/homework1/` or `cd ..`

## Other Useful Commands

- Show your current directory: `pwd` (In Windows Command Prompt is `cd`)
- Show contents of current directory: `ls` (In Windows Command Prompt is `dir`)
- Make a new directory: `mkdir dirname`
- Rename a file or directory: `mv oldname newname` (In Windows Command Prompt is `move`)
- Delete a file: `rm filename` (In Windows Command Prompt is `del`)
- Delete an empty directory: `rmdir dirname` or `rm -r dirname`

# Java Review

## Java Program Compilation and Running

Assume your program file name is `Example.java` and it includes an `Example` class

1.  Before compiling and running your Java program, make sure your current directory is correct (your program should be under your current directory)
2.  To compile your program, run: `javac Example.java`
3.  To execute the compiled program, run: `java Example`

You may also use VSCode plugins to directly run your code, but it may skip some compilation errors, which is typically not we want. 

## Java Classes in a Single File

A single Java file can contain multiple classes, and when you compile it, you get multiple `.class` files — one for each class defined in the Java file.

### Example Java File

Let's say you have a file named `Example.java` with the following content:

``` Java
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
```

- `Example` Class: This is the public class that contains the `main` method, serving as the entry point of the program.

- `Helper` Class: A package-private class with a method `displayMessage()` that prints a message.

- `Utility` Class: Another package-private class with a method `printNumber(int number)` that prints the provided number.

**NOTE 1**: Classes without an explicit access modifier (like public or private) are package-private, meaning they are accessible only within the same package.

**NOTE 2**: As I mentioned in the last discussion section, if you want your Java file runnable, you must have a **public** class name exactly the same as the filename. This class should have a static public method named `main`, serving as the entry point for your program.

When you compile `Example.java` using the `javac` compiler, the compiler generates three separate `.class` files. Each `.class` file corresponds to one class defined in your Java file.

When you run the program `Example` using `java`, the output is

```
This is the main class.
This is the helper class.
Utility class received number: 42
```

# Primitive Data Types

There are 8 primitive data types (note 1 byte = 8bits). Data with n bits can represent up to 2<sup>n</sup> different numbers.

- **byte**: 1 byte integer, range \[−2<sup>7</sup> , 2<sup>7</sup> − 1\]
- **short**: 2 byte integer, range \[−2<sup>15</sup> , 2<sup>15</sup> − 1\]
- **int**: 4 byte integer, range \[−2<sup>31</sup> , 2<sup>31</sup> − 1\]
- **long**: 8 byte integer, range \[−2<sup>63</sup> , 2<sup>63</sup> − 1\]

It's important to ensure that the values being used and calculated are within the range of their respective data types.

# Discussion Section on Thursday (10.3)

We will review more data types on representing numbers. The overflow/underflow errors when you do not follow the range of data types carefully. And the conversions between different data types.