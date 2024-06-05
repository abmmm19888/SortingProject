---

# SortingProject

## Description

The objective of this project is to develop a Java program that allows users to enter a list of numbers and sort it in ascending or descending order, according to their choice. The program is capable of handling different quantities of numbers and ensures an efficient and accurate sorting process.

## Steps Taken

### 1. Creating the Repository on GitHub

First, a new repository called "SortingProject" was created on GitHub.

### 2. Cloning the Repository

The `git clone` command followed by the repository URL was used to clone the empty repository to the local computer. The complete command was:

```bash
git clone https://github.com/abmmm19888/SortingProject.git
```

### 3. Creating the Source Code

The project's source code was written in Java in the `Main.java` file inside the `src` folder. This code implements the logic to sort a list of numbers entered by the user. Here is an example of the code used:

```java
package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int ASCENDING = 1;
    private static final int DESCENDING = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            System.out.println("Enter numbers separated by spaces (the number 4 is not allowed):");

            readNumbers(scanner, numbers);

            System.out.println("Select the type of sorting: 1 for ascending, 2 for descending:");
            sortAndDisplay(scanner, numbers);
        }
    }

    private static void readNumbers(Scanner scanner, ArrayList<Integer> numbers) {
        String[] input = scanner.nextLine().split(" ");
        for (String str : input) {
            try {
                int number = Integer.parseInt(str);
                if (number == 4) {
                    System.out.println("The number 4 is not allowed. Program terminated.");
                    return;
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Program terminated.");
                return;
            }
        }
    }

    private static void sortAndDisplay(Scanner scanner, ArrayList<Integer> numbers) {
        try {
            int sortType = scanner.nextInt();
            String message = switch (sortType) {
                case ASCENDING -> {
                    sortListUsingBubbleSort(numbers, true);
                    yield "Sorted list in ascending order: " + numbers;
                }
                case DESCENDING -> {
                    sortListUsingBubbleSort(numbers, false);
                    yield "Sorted list in descending order: " + numbers;
                }
                default -> "Invalid option. Program terminated.";
            };
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Invalid input. Program terminated.");
        }
    }

    public static void sortListUsingBubbleSort(ArrayList<Integer> list, boolean ascending) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                boolean shouldSwap = (ascending && list.get(j) > list.get(j + 1)) || (!ascending && list.get(j) < list.get(j + 1));
                if (shouldSwap) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
```

### 4. Compiling and Running the Program

The `javac` command was used to compile the `Main.java` file, and then the resulting program was run with the `java` command. The commands were:

```bash
javac src/com/example/Main.java
java com.example.Main
```

### 5. Error Correction and Testing

Errors that arose during the development process were corrected, and the program was tested to ensure it worked as expected.

### 6. Configuring and Pushing to the Remote Repository

The remote repository was configured using the `git remote add origin` command to establish the connection with the GitHub repository. Then, the changes were pushed to the remote repository using the `git push` command. The commands were:

```bash
git remote add origin https://github.com/abmmm19888/SortingProject.git
git pull origin master --allow-unrelated-histories
git push -u origin master
```
