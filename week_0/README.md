# Introduction

### Welcome to PIC 20A!

## About me

I'm Chang Yu, a second-year PhD student in Computer Science, co-advised by Prof. Chenfanfu Jiang and Prof. Demetri Terzopoulos. My research interests lie in computer graphics, robotics, and computational physics. I am focusing on reproducing the real-world robots behaviors using computer simulation accurately.

## Contact me

- Email: changyu1@g.ucla.edu
- Discussion section: Tuesday & Thursday, 1:00 PM - 1:50 PM, Geology Building 6704, **in-person**
- Office hour: Monday, 2:00 PM - 3:30 PM, PIC lab (Mathematical Sciences 2000)

## Important facts

- In PIC 20A, TAs **do not** grade homework. I cannot help you if you feel you have been graded unfairly. I do not process regrade requests. You can either talk to the professor or submit a regrade request.
- Most frequently, your code will be graded by running test cases. In this scenario, **if your code does not compile**, no test cases can be run and **you may probably receive 0 points.**
- If you have any homework questions, I recommend that you attend my office hours for assistance. It's easier for me to review and help with your code in person. However, if you prefer to communicate via email, please ensure that your questions are clearly stated and include the relevant parts of your code. I will do my best to address your concerns.

## Structure of discussion section

- Review the content covered in the last one or two lectures
- Work on some exercises to help you understand and practice
    - You will first have some time to write and test your own codes, and you may discuss with your classmates
    - I will then show you my solution
- Sometimes I will give you some hints on the homework.

# Installing VS code & JDK

## VS code installation

Go to the website: https://code.visualstudio.com/download, and choose one to download based on your computer's system.

You may just use the default setting when running the installation package.

## JDK

### JVM, JRE & JDK

Three abbreviations you’ll see when installing Java are JVM (Java Virtual Machine), JRE (Java Runtime Environment), and JDK (Java Development Kit).

The JVM is an abstract machine that **provides an environment in which Java bytecode can be executed**. It interprets the bytecode and translates it into machine-specific instructions, allowing Java code to run on any platform that has a JVM installed. The JVM also manages memory, provides security features, and performs other tasks to ensure that Java programs run correctly and efficiently.

The JRE is a subset of the JDK and **provides the minimum set of tools required to run Java application**s. It includes the JVM (Java Virtual Machine), which is responsible for executing Java bytecode. Without a JRE, you wouldn’t be able to run Java code.

The JDK **includes a copy of the JRE, plus the Java compiler** (and other programmer-specific tools). Most people don’t need the JDK, since they only run compiled Java programs. But we’re going to be compiling programs ourselves, so we should install the JDK. With JDK, the java code can be compiled into bytecode.

[More about JDK, JRE, and JVM](https://www.geeksforgeeks.org/differences-jdk-jre-jvm/)

One benefit of Java: **compile once, run anywhere**! (as long as JRE/JDK is correctly installed on your computer)

### JDK installation

- After opening Visual Studio Code, select “Extensions” from the left hand side (the 5-th icon down at the time of writing).
- Search for and install “Extension Pack for Java”.
- After the install is complete, you’ll be prompted to install JDK. (If you’re not prompted to do so, you can go to “View” (at the top), followed by “CommandPalette...”, and type “Java: Install New JDK”.)
- Then you will be asked to determine some of the settings of JDK. You can choose as suggested by the following:
    - We’re happy with Adoptium’s Temurin.
    - Select Version 11 (LTS).
    - For JVM, we’re fine with Hotspot.
- After the installation, restart Visual Studio Code.
- You can check your installation by: selecting “Terminal”(at the top), followed by “New Terminal”, and typing java -version. Hopefully, you’ll see...

```Java
openjdk version "11.0.18" 2023-01-17
OpenJDK Runtime Environment Temurin-11.0.18+10 (build 11.0.18+10)
OpenJDK 64-Bit Server VM Temurin-11.0.18+10 (build 11.0.18+10, mixed mode)
```

# First Java program!

Create a Java code file named `HelloWorld.java`

```Java
// First snippet in Java

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        // System.out.println does what it says:
        // it prints a line to the console.
        // println means printing and then changing a new line
        // you can also use print; it does not move to a new line after printing

    }
}
```

To compile and run the program, type the following command in your terminal:

```shell
javac HelloWorld.java
java HelloWorld
```

# Frequently asked questions

1. How do I install the correct version of Java (Java 11) if I have installed some other version (say Java 23, Java 17 or Java 8)?

**TL;DR** Actually, it doesn't matter as long as you can compile and run your code successfully since we will not dive into the advanced features related to the specific Java version in this course. : )

- Download JDK 11 following the previous instructions.

- Select “Terminal”(at the top), followed by “New Terminal”, and type the following:
    - For MacOS:
      - Type this command
      ``` Bash
      /usr/libexec/java_home -V
      ```
      to find the installed Java versions. Your output should look like:
      ``` Bash
      Matching Java Virtual Machines (2):
      17.0.6 (arm64) "Eclipse Adoptium" - "OpenJDK 17.0.6" /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
      11.0.17 (arm64) "Eclipse Adoptium" - "OpenJDK 11.0.17" /Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
      /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
      ```
      - Switch to 11 by inputting the following:
      ``` Bash
      export JAVA_HOME=`/usr/libexec/java_home -v 11.0`
      export PATH=$JAVA_HOME/bin:$PATH
      ```
    - For Ubuntu and other Linux systems:
      - You can find the installed Java versions in the `/usr/lib/jvm/` directory. Run this command to list them:
      ``` Bash
      ls /usr/lib/jvm/
      ```
      You should see a list of installed Java versions, such as:
      ``` Bash
      java-11-openjdk-amd64  java-17-openjdk-amd64
      ```
      You can set the JAVA_HOME environment variable to switch to JDK 11:
      ``` Bash
      export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
      export PATH=$JAVA_HOME/bin:$PATH
      ```
    - For Windows:
      - Type (Find the path where your JDK 11 was installed and replace it in the following code snippet):
      ``` Bash
      set JAVA_HOME= <Your path to JAVA version 11>
      set PATH=%JAVA_HOME%\bin;%PATH%
      ```
      - Another method is - Look at the first answer in this [link](https://superuser.com/questions/262757/changing-current-version-of-java-within-windows) but replace it with the location 




