# Stack Visualization

## 1. Project Title
StackCraft: Interactive Stack Operations

## 2. Group Name
Group Name: [GUYS2 PWEDE MAGTANONG?]

## 3. Group Members
- TACAN
- GANDING
- BARANDA
- MALLARI
- PAHUYO


## 4. Description of the Program
The Stack Visualization program is a Java application that shows how a stack works using a graphical user interface (GUI). It helps users understand the **Last In, First Out (LIFO)** concept, which means the last item added to the stack is the first item removed. Users can perform different stack operations and see the changes on the screen.

## 5. Features
- PUSH – Adds a value to the top of the stack.
- POP – Removes the top value from the stack.
- PEEK – Shows the top value without removing it.
- CLEAR – Removes all values from the stack.
  CHECK STACK – Checks the stack's current status and size.
- RANDOM – Generates random values and displays them in the stack.
- isual Display – Shows the stack elements as blocks and highlights the top element.
  Overflow and Underflow Handling – Displays messages when the stack is full or empty and an operation cannot be completed.

## 6. Requirements
- Java Development Kit (JDK)
- Java-compatible IDE or code editor, such as NetBeans, IntelliJ IDEA, or Visual Studio Code
- Java Swing and AWT libraries for the graphical interface

## 7. How to Run the Program
1. Install the JDK on your computer.
2. Download or clone the project from the GitHub repository.
3. Open the project folder in your Java IDE or code editor.
4. Make sure `Stack.java` and `StackGUI.java` are in the same folder.
5. Compile the Java files.
6. Run `StackGUI.java`, which contains the main method.
7. The Stack Visualization window will open. Enter a value and click the buttons to test the different operations.

## 8. Project Structure
```text
StackVisualization/
├── Stack.java
└── StackGUI.java
```

- Stack.java – Contains the stack data structure and its operations.
- StackGUI.java – Creates the graphical interface, buttons, stack display, and status messages.

## 9. Stack Implementation
The program uses an **array-based stack** with a maximum capacity of 10 elements. It follows the LIFO principle. The `top` variable keeps track of the top element, starting at `-1` when the stack is empty.

The `Stack` class contains methods for pushing, popping, peeking, checking whether the stack is empty or full, checking its size, clearing the stack, and accessing elements for display.

## 10. Screenshots
Add screenshots of your actual running program here, such as:
- Main Stack Visualization window
- PUSH operation
- POP operation
- PEEK operation
- CHECK STACK result
- RANDOM operation
- CLEAR operation
- Stack overflow and underflow messages

## 11. AI Disclosure
ChatGPT (GPT-6) was used to help draft and explain parts of the Java code, guide the program setup, and assist with the project documentation. The group reviewed the code and checked the program by running it.

## 12. Contributors
- TACAN  -  Worked on Tasks 4 and 5, including running the program, performing test cases, capturing screenshots of the test executions, and documenting the errors encountered and their fixes.
- GANDING  - Worked on the Java program, designed the graphical user interface (GUI), tested the stack operations, and helped set up the GitHub repository.
- BARANDA  - Prepared the project documentation, including written answers, essay questions, tables, and other required written activities.
- MALLARI  - Inserted pictures and screenshots into the documentation and corrected spelling and typing errors in the document.
- PAHUYO   -  Reviewed the completed project, checked the documentation for completeness, and helped organize the final submission.
Update the names and contributions based on each member's actual work.
